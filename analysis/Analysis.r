library(readxl)
library(texreg)
library(stargazer)
library(doBy)
library(dplyr)
library(reshape2)
library(ggplot2)
library(nlme)
library(multcomp)
library(metafor)
library(lsmeans)
library(car)

obtainEstimateSE <- function(model,site){
  # IPD second-stage
  tmp<- summary(glht(model))
  temp <- tmp$test$coefficients[["TREATMENT"]]
  tempse <- tmp$test$sigma[["TREATMENT"]]
  tempDF <- data.frame(yi=c(temp), vi=c(tempse^2), EXPERIMENT=c(site))
  allEstimatesSE <<-rbind(allEstimatesSE,tempDF)
}



# Read the raw data

d <- as.data.frame(read_excel("Raw Data.xlsx"))
moderators<- as.data.frame(read_excel("Map.xlsx"))
## Print descriptive statistics of participants' experiences

d <- d[with(d, order(EXPERIMENT, TREATMENT, SUBJECT_ID)), ]
d$SUBJECT_ID<-as.factor(d$SUBJECT_ID)
d$EXPERIMENT<-as.factor(d$EXPERIMENT)

experiences <- distinct(d, SUBJECT_ID, .keep_all = TRUE)
by(experiences, experiences$EXPERIMENT, function(dTemp){
  nrow(dTemp)
})

experiences <- experiences[,c("EXPERIMENT","PROGRAMMING","JAVA","UNIT_TESTING","JUNIT")]

summaryBy(. ~ EXPERIMENT, data=experiences, FUN = function(x) { c(m = mean(x, na.rm=TRUE), s = sd(x, na.rm=TRUE)) } )

## Provide profile-plot for participants' mean experiences

mdf <- summaryBy(. ~ EXPERIMENT, data=experiences, na.rm=TRUE)
longMdf<-melt(mdf, id.vars = c("EXPERIMENT"))
longMdf$variable <- as.character(longMdf$variable)
longMdf$variable[longMdf$variable=="PROGRAMMING.mean"] <- "Programming"
longMdf$variable[longMdf$variable=="JAVA.mean"] <- "Language"
longMdf$variable[longMdf$variable=="UNIT_TESTING.mean"] <- "Unit Test"
longMdf$variable[longMdf$variable=="JUNIT.mean"] <- "Testing Tool"

longMdf$variable<- as.factor(longMdf$variable)
longMdf$variable<-factor(longMdf$variable,levels(longMdf$variable)[c(2,1,4,3)])

ggplot(data=longMdf, aes(x=as.factor(variable), y=value, group = EXPERIMENT, colour = EXPERIMENT)) +
  geom_line() +   geom_point( size=4, shape=21, fill="white")+ 
  labs(x="", y="Mean experience") + theme_bw() + scale_y_continuous(limits=c(1,4))

## Provide profile-plot in different groups (ordinal scale with/without years)

with <- subset(longMdf, EXPERIMENT=="Company 2" | EXPERIMENT=="Company 1" | EXPERIMENT=="University 1" | EXPERIMENT=="University 4" | EXPERIMENT=="University 8")
without <- subset(longMdf, EXPERIMENT=="Company 3" | EXPERIMENT=="Company 4" | EXPERIMENT=="University 5" | EXPERIMENT=="University 2" | EXPERIMENT=="University 6" | EXPERIMENT=="University 7" | EXPERIMENT=="University 3")


ggplot(data=with, aes(x=as.factor(variable), y=value, group = EXPERIMENT, colour = EXPERIMENT)) +
  geom_line() +   geom_point( size=4, shape=21, fill="white")+ 
  labs(x="", y="Mean experience") + theme_bw() + scale_y_continuous(limits=c(1,4), breaks=c(1,2,3,4), labels=c("Inexperienced","Novice","Intermediate","Expert"))

ggplot(data=without, aes(x=as.factor(variable), y=value, group = EXPERIMENT, colour = EXPERIMENT)) +
  geom_line() +   geom_point( size=4, shape=21, fill="white")+ 
  labs(x="", y="Mean experience") + theme_bw() + scale_y_continuous(limits=c(1,4), breaks=c(1,2,3,4), labels=c("Inexperienced","Novice","Intermediate","Expert"))

#######################################################################################################################
################################################################################## Step 2. Conduct the individual analyses
####################################################################################################################### 

### Activity 1. Provide summary statistics and box-plots

## Provide descriptive statistics

mdf<-do.call(data.frame, aggregate(QLTY ~ TREATMENT + EXPERIMENT, FUN = function(x)
  c(N = length(x), MEAN = mean(x), SD=sd(x) ,MDN=median(x)), data=d))
print(mdf[,c("EXPERIMENT","TREATMENT","QLTY.N","QLTY.MEAN","QLTY.SD","QLTY.MDN")])

stargazer(mdf[,c("EXPERIMENT","TREATMENT","QLTY.N","QLTY.MEAN","QLTY.SD","QLTY.MDN")], summary=FALSE, rownames = FALSE)

### Activity 2. Provide profile-plot

## Provide profile-plots

mdf<-aggregate(QLTY ~ TREATMENT + EXPERIMENT, FUN=mean, data=d)
ggplot(data=mdf, aes(x=as.factor(TREATMENT), y=QLTY, group = EXPERIMENT, colour = EXPERIMENT)) +
  geom_line() +   geom_point( size=4, shape=21, fill="white")+ labs(x="Treatment", y="QLTY") + 
  scale_x_discrete(labels=c("ITL", "TDD")) + scale_y_continuous(limits=c(0,100)) +
  theme_bw()


# Read experiments independently
dUni1 <-subset(d, EXPERIMENT=="University 1")
dComp1 <-subset(d, EXPERIMENT=="Company 1")
dComp2 <-subset(d, EXPERIMENT=="Company 2")
dUni2 <-subset(d, EXPERIMENT=="University 2")
dUni3 <- subset(d, EXPERIMENT=="University 3")
dComp3 <-subset(d, EXPERIMENT=="Company 3")
dComp4 <- subset(d, EXPERIMENT=="Company 4")
dUni4 <- subset(d, EXPERIMENT=="University 4")
dUni5 <- subset(d, EXPERIMENT=="University 5")
dUni6<- subset(d,EXPERIMENT=="University 6")
dUni7<- subset(d,EXPERIMENT=="University 7")
dUni8 <- subset(d, EXPERIMENT=="University 8")


# Analyze each independently
print(summary(modelUni1<-gls(QLTY ~ TREATMENT ,data=dUni1, corr=corCompSymm(form=~1|SUBJECT_ID), na.action = na.omit)))
print(summary(modelComp1<-gls(QLTY ~ TREATMENT ,data=dComp1, corr=corCompSymm(form=~1|SUBJECT_ID), na.action = na.omit)))
print(summary(modelComp2<-gls(QLTY ~ TREATMENT ,data=dComp2, corr=corCompSymm(form=~1|SUBJECT_ID), na.action = na.omit)))
print(summary(modelUni2<-gls(QLTY ~ TREATMENT ,data=dUni2, corr=corCompSymm(form=~1|SUBJECT_ID), na.action = na.omit)))
print(summary(modelUni3<-gls(QLTY ~ TREATMENT ,data=dUni3, corr=corCompSymm(form=~1|SUBJECT_ID), na.action = na.omit)))
print(summary(modelComp3<-gls(QLTY ~ TREATMENT ,data=dComp3, corr=corCompSymm(form=~1|SUBJECT_ID), na.action = na.omit)))
print(summary(modelComp4<-gls(QLTY ~ TREATMENT ,data=dComp4, corr=corCompSymm(form=~1|SUBJECT_ID), na.action = na.omit)))
print(summary(modelUni4<-gls(QLTY ~ TREATMENT ,data=dUni4, corr=corCompSymm(form=~1|SUBJECT_ID), na.action = na.omit)))
print(summary(modelUni5<-lm(QLTY ~ TREATMENT ,data=dUni5)))
print(summary(modelUni6<-lm(QLTY ~ TREATMENT,data=dUni6)))
print(summary(modelUni7<-lm(QLTY ~ TREATMENT ,data=dUni7)))
print(summary(modelUni8<-lm(QLTY ~ TREATMENT,data=dUni8)))


allEstimatesSE <- data.frame(yi=numeric(0), vi=numeric(0), EXPERIMENT=character(0))
obtainEstimateSE(modelUni1,"University 1")
obtainEstimateSE(modelComp1,"Company 1")
obtainEstimateSE(modelComp2,"Company 2")
obtainEstimateSE(modelUni2,"University 2")
obtainEstimateSE(modelUni3,"University 3")
obtainEstimateSE(modelComp3,"Company 3")
obtainEstimateSE(modelComp4,"Company 4")
obtainEstimateSE(modelUni4,"University 4")
obtainEstimateSE(modelUni5,"University 5")
obtainEstimateSE(modelUni6,"University 6")
obtainEstimateSE(modelUni7,"University 7")
obtainEstimateSE(modelUni8,"University 8")


#######################################################################################################################
################################################################################## Step 3. Aggregate the results
####################################################################################################################### 

############## 1. Joint result for QLTY

allEstimatesSE <- merge(allEstimatesSE,moderators,by="EXPERIMENT")
allEstimatesSE$EXPERIMENT  <- with(allEstimatesSE, reorder(EXPERIMENT, ORDER))

par(mar=c(4,4,1,2))
# IPD two-stages
meta.MC = rma(yi=yi,vi=vi,slab=EXPERIMENT, data=allEstimatesSE, method="REML")
par(font=1)
forest(meta.MC, xlab="Effect Size", mlab="", order=order(allEstimatesSE$ORDER))
par(font=2)
### add column headings to the plot
text(c(-20,20), 14, c("TDD<ITL", "TDD>ITL"))
text(-161, 14 , "Experiment",  pos=4)
text(161, 14, "Effect Size [95% CI]", pos=2)
text(-161, -1, pos=4, cex=0.75, bquote(paste("RE Model (Q = ",
                                             .(formatC(meta.MC$QE, digits=2, format="f")),
                                             ", p = ", .(formatC(meta.MC$QEp, digits=2, format="f")), "; ", I^2, " = ",
                                             .(formatC(meta.MC$I2, digits=1, format="f")), "%)")))
# IPD one-stage
summary(a<-lme(QLTY ~ as.factor(TREATMENT),
               random=list(EXPERIMENT=~TREATMENT, SUBJECT_ID=~1),
               data=d, na.action = na.exclude, control=lmeControl(opt='optim')))
anova(a)
lsmeans(a, ~ TREATMENT, type="response")


############## 2. Joint result for tasks

daux<- d
daux$TREATMENT[daux$TREATMENT==1] <-"ITL"
daux$TREATMENT[daux$TREATMENT==2] <-"TDD"
daux <- subset(daux, TASK=="1" | TASK=="2")
daux$TASK[daux$TASK==1] <-"MR"
daux$TASK[daux$TASK==2] <-"BSK"
daux$TASK <- as.factor(daux$TASK)
daux$TREATMENT<- as.factor(daux$TREATMENT)
daux[] <- lapply(daux, function(x) if(is.factor(x)) factor(x) else x)


# IPD one-stage
summary(a<-lme(QLTY ~ TREATMENT*TASK,
               random=list(EXPERIMENT=~TREATMENT, SUBJECT_ID=~1),
               data=daux, na.action = na.exclude, control=lmeControl(opt='optim')))

Anova(a)


lsmeans(a, ~ TREATMENT*TASK,  type="response")
lsmeans(a, pairwise~ TASK|TREATMENT,  type="response")
lsmeans(a, pairwise~ TREATMENT|TASK,  type="response")



############## 3. Joint result for tests

# IPD one-stage
summary(a<-lme(QLTY ~ TREATMENT*TESTS,
               random=list(EXPERIMENT=~TREATMENT, SUBJECT_ID=~1),
               data=daux, na.action = na.exclude, control=lmeControl(opt='optim')))

Anova(a)

lsmeans(a, ~ TREATMENT*TESTS, type="response")
lsmeans(a, pairwise~ TREATMENT|TESTS, type="response")


summary(a<-lme(TESTS ~ TREATMENT*TASK,
               random=list(EXPERIMENT=~TREATMENT, SUBJECT_ID=~1),
               data=daux, na.action = na.exclude, control=lmeControl(opt='optim')))

Anova(a)

lsmeans(a, ~ TREATMENT*TASK, type="response")
lsmeans(a, pairwise~ TREATMENT|TASK, type="response")


#######################################################################################################################
################################################################################## Step 4. Exploratory Analyses
####################################################################################################################### 

# Type of subject

summary(a<-lme(QLTY ~ TREATMENT*SUBJECT_TYPE,
               random=list(EXPERIMENT=~TREATMENT, SUBJECT_ID=~1),
               data=daux, na.action = na.exclude, control=lmeControl(opt='optim')))

Anova(a)

lsmeans(a, ~ TREATMENT*SUBJECT_TYPE, type="response")
lsmeans(a, pairwise~ TREATMENT|SUBJECT_TYPE, type="response")
lsmeans(a, pairwise~ SUBJECT_TYPE|TREATMENT, type="response")


allEstimatesSE1 <- allEstimatesSE[which(allEstimatesSE$TYPE_OF_SUBJECT=="S"),]
allEstimatesSE2 <- allEstimatesSE[which(allEstimatesSE$TYPE_OF_SUBJECT=="P"),]
summary(res<-rma(yi=yi,vi=vi,slab=EXPERIMENT, data=allEstimatesSE, method="REML"))
summary(res1<-rma(yi=yi,vi=vi,method="REML", data=allEstimatesSE1))
summary(res2<-rma(yi=yi,vi=vi,method="REML", data=allEstimatesSE2))
dat.comp <- data.frame(estimate = c(coef(res1), coef(res2)), stderror = c(res1$se, res2$se),
                       design = c("Students","Professionals"), tau2 = round(c(res1$tau2, res2$tau2),3))
rma(estimate, sei=stderror, mods = ~ design, method="FE", data=dat.comp, digits=3)


par(mar=c(4,4,1,2))
par(font=1)
forest(res, xlab="Effect Size",mlab="", ylim=c(-1, 19), rows=c(15:8,5:2), order=order(allEstimatesSE$ORDER_TYPE_OF_SUBJECT))
par(font=2)
text(-145, 16, "Students")
par(font=1)
addpoly(res1, row=7,  mlab="")
par(font=2)
text(-138, 6, "Professionals")
par(font=1)
addpoly(res2, row=1,  mlab="")


par(font=2)
text(c(-20,20), 18, c("TDD<ITL", "TDD>ITL"))
text(-161, 18 , "Experiment",  pos=4)
text(161, 18, "Effect Size [95% CI]", pos=2)
text(-161, -1, pos=4, cex=0.75, bquote(paste("RE Model (Q = ",
                                             .(formatC(meta.MC$QE, digits=2, format="f")),
                                             ", p = ", .(formatC(meta.MC$QEp, digits=2, format="f")), "; ", I^2, " = ",
                                             .(formatC(meta.MC$I2, digits=1, format="f")), "%)")))

par(font=1)
text(-161, 7, pos=4, cex=0.75, bquote(paste("RE Model subgroup (Q = ",
                                            .(formatC(res1$QE, digits=2, format="f")),
                                            ", p = ", .(formatC(res1$QEp, digits=2, format="f")), "; ", I^2, " = ",
                                            .(formatC(res1$I2, digits=1, format="f")), "%)")))

text(-161, 1, pos=4, cex=0.75, bquote(paste("RE Model subgroup (Q = ",
                                            .(formatC(res2$QE, digits=2, format="f")),
                                            ", p = ", .(formatC(res2$QEp, digits=2, format="f")), "; ", I^2, " = ",
                                            .(formatC(res2$I2, digits=1, format="f")), "%)")))



# Programming environment

summary(a<-lme(QLTY ~ TREATMENT*PROGRAMMING_ENVIRONMENT,
               random=list(EXPERIMENT=~TREATMENT, SUBJECT_ID=~1),
               data=daux, na.action = na.exclude, control=lmeControl(opt='optim')))

Anova(a)

lsmeans(a, ~ PROGRAMMING_ENVIRONMENT*TREATMENT, type="response")
lsmeans(a, pairwise~ TREATMENT|PROGRAMMING_ENVIRONMENT, type="response")
lsmeans(a, pairwise~ PROGRAMMING_ENVIRONMENT|TREATMENT, type="response")


allEstimatesSE1 <- allEstimatesSE[which(allEstimatesSE$PROGRAMMING_ENVIRONMENT=="Java"),]
allEstimatesSE2 <- allEstimatesSE[which(allEstimatesSE$PROGRAMMING_ENVIRONMENT=="C"),]
summary(res<-rma(yi=yi,vi=vi,slab=EXPERIMENT, data=allEstimatesSE, method="REML"))
summary(res1<-rma(yi=yi,vi=vi,method="REML", data=allEstimatesSE1))
summary(res2<-rma(yi=yi,vi=vi,method="REML", data=allEstimatesSE2))
dat.comp <- data.frame(estimate = c(coef(res1), coef(res2)), stderror = c(res1$se, res2$se),
                       design = c("Java environment","C environment"), tau2 = round(c(res1$tau2, res2$tau2),3))
rma(estimate, sei=stderror, mods = ~ design, method="FE", data=dat.comp, digits=3)


par(mar=c(4,4,1,2))
par(font=1)
forest(res, xlab="Effect Size",mlab="", ylim=c(-1, 19), rows=c(15:8,5:2), order=order(allEstimatesSE$ORDER_PROGRAMMING_ENVIRONMENT))
par(font=2)
text(-133, 16, "Java environment")
par(font=1)
addpoly(res1, row=7,  mlab="")
par(font=2)
text(-137, 6, "C environment")
par(font=1)
addpoly(res2, row=1,  mlab="")


par(font=2)
text(c(-20,20), 18, c("TDD<ITL", "TDD>ITL"))
text(-161, 18 , "Experiment",  pos=4)
text(161, 18, "Effect Size [95% CI]", pos=2)
text(-161, -1, pos=4, cex=0.75, bquote(paste("RE Model (Q = ",
                                             .(formatC(meta.MC$QE, digits=2, format="f")),
                                             ", p = ", .(formatC(meta.MC$QEp, digits=2, format="f")), "; ", I^2, " = ",
                                             .(formatC(meta.MC$I2, digits=1, format="f")), "%)")))

par(font=1)
text(-161, 7, pos=4, cex=0.75, bquote(paste("RE Model subgroup (Q = ",
                                            .(formatC(res1$QE, digits=2, format="f")),
                                            ", p = ", .(formatC(res1$QEp, digits=2, format="f")), "; ", I^2, " = ",
                                            .(formatC(res1$I2, digits=1, format="f")), "%)")))

text(-161, 1, pos=4, cex=0.75, bquote(paste("RE Model subgroup (Q = ",
                                            .(formatC(res2$QE, digits=2, format="f")),
                                            ", p = ", .(formatC(res2$QEp, digits=2, format="f")), "; ", I^2, " = ",
                                            .(formatC(res2$I2, digits=1, format="f")), "%)")))

# Learning effects

summary(a<-lme(QLTY ~ TREATMENT*REPEATED,
               random=list(EXPERIMENT=~TREATMENT, SUBJECT_ID=~1),
               data=daux, na.action = na.exclude, control=lmeControl(opt='optim')))

Anova(a)

lsmeans(a, ~ REPEATED*TREATMENT, type="response")
lsmeans(a, pairwise~ TREATMENT|REPEATED, type="response")
lsmeans(a, pairwise~ REPEATED|TREATMENT, type="response")


allEstimatesSE1 <- allEstimatesSE[which(allEstimatesSE$DESIGN!="Between"),]
allEstimatesSE2 <- allEstimatesSE[which(allEstimatesSE$DESIGN=="Between"),]

summary(res1<-rma(yi=yi,vi=vi,method="REML", data=allEstimatesSE1))
summary(res2<-rma(yi=yi,vi=vi,method="REML", data=allEstimatesSE2))
dat.comp <- data.frame(estimate = c(coef(res1), coef(res2)), stderror = c(res1$se, res2$se),
                       design = c("Within","Between"), tau2 = round(c(res1$tau2, res2$tau2),3))
rma(estimate, sei=stderror, mods = ~ design, method="FE", data=dat.comp, digits=3)


par(mar=c(4,4,1,2))
par(font=1)
forest(res, xlab="Effect Size",mlab="", ylim=c(-1, 19), rows=c(15:8,5:2), order=order(allEstimatesSE$ORDER_WITHIN_BETWEEN))
par(font=2)
text(-150, 16, "Within")
par(font=1)
addpoly(res1, row=7,  mlab="")
par(font=2)
text(-146, 6, "Between")
par(font=1)
addpoly(res2, row=1,  mlab="")


par(font=2)
text(c(-20,20), 18, c("TDD<ITL", "TDD>ITL"))
text(-161, 18 , "Experiment",  pos=4)
text(161, 18, "Effect Size [95% CI]", pos=2)
text(-161, -1, pos=4, cex=0.75, bquote(paste("RE Model (Q = ",
                                             .(formatC(meta.MC$QE, digits=2, format="f")),
                                             ", p = ", .(formatC(meta.MC$QEp, digits=2, format="f")), "; ", I^2, " = ",
                                             .(formatC(meta.MC$I2, digits=1, format="f")), "%)")))

par(font=1)
text(-161, 7, pos=4, cex=0.75, bquote(paste("RE Model subgroup (Q = ",
                                            .(formatC(res1$QE, digits=2, format="f")),
                                            ", p = ", .(formatC(res1$QEp, digits=2, format="f")), "; ", I^2, " = ",
                                            .(formatC(res1$I2, digits=1, format="f")), "%)")))

text(-161, 1, pos=4, cex=0.75, bquote(paste("RE Model subgroup (Q = ",
                                            .(formatC(res2$QE, digits=2, format="f")),
                                            ", p = ", .(formatC(res2$QEp, digits=2, format="f")), "; ", I^2, " = ",
                                            .(formatC(res2$I2, digits=1, format="f")), "%)")))



# Order

daux <- subset(daux, CROSS=="Within" | CROSS=="Cross")

summary(a<-lme(QLTY ~ TREATMENT*CROSS,
               random=list(EXPERIMENT=~TREATMENT, SUBJECT_ID=~1),
               data=daux, na.action = na.exclude, control=lmeControl(opt='optim')))

Anova(a)

lsmeans(a, ~ CROSS*TREATMENT, type="response")
lsmeans(a, pairwise~ TREATMENT|CROSS, type="response")
lsmeans(a, pairwise~ CROSS|TREATMENT, type="response")

allEstimatesSE1 <- allEstimatesSE[which(allEstimatesSE$DESIGN=="Within"),]
allEstimatesSE2 <- allEstimatesSE[which(allEstimatesSE$DESIGN=="Cross-Over"),]

allEstimatesSEaux <- rbind(allEstimatesSE1, allEstimatesSE2)

summary(res1<-rma(yi=yi,vi=vi,method="REML", data=allEstimatesSE1))
summary(res2<-rma(yi=yi,vi=vi,method="REML", data=allEstimatesSE2))
dat.comp <- data.frame(estimate = c(coef(res1), coef(res2)), stderror = c(res1$se, res2$se),
                       design = c("AB Within","Cross-Over"), tau2 = round(c(res1$tau2, res2$tau2),3))
rma(estimate, sei=stderror, mods = ~ design, method="FE", data=dat.comp, digits=3)


summary(res<-rma(yi=yi,vi=vi,slab=EXPERIMENT, data=allEstimatesSEaux, method="REML"))


par(mar=c(4,4,1,2))
par(font=1)
orderazo <- allEstimatesSEaux$ORDER_WITHIN_CROSS[!is.na(allEstimatesSEaux$ORDER_WITHIN_CROSS)]
forest(res, xlab="Effect Size",mlab="", ylim=c(-1, 15), rows=c(11:5,2), order=order(orderazo))
par(font=2)
text(-145, 12, "AB within")
par(font=1)
addpoly(res1, row=4,  mlab="")
par(font=2)
text(-143, 3, "Cross-over")
par(font=1)
addpoly(res2, row=1,  mlab="")


par(font=2)
text(c(-20,20), 14, c("TDD<ITL", "TDD>ITL"))
text(-161, 14 , "Experiment",  pos=4)
text(161, 14, "Effect Size [95% CI]", pos=2)
text(-161, -1, pos=4, cex=0.75, bquote(paste("RE Model (Q = ",
                                             .(formatC(meta.MC$QE, digits=2, format="f")),
                                             ", p = ", .(formatC(meta.MC$QEp, digits=2, format="f")), "; ", I^2, " = ",
                                             .(formatC(meta.MC$I2, digits=1, format="f")), "%)")))

par(font=1)
text(-161, 4, pos=4, cex=0.75, bquote(paste("RE Model subgroup (Q = ",
                                            .(formatC(res1$QE, digits=2, format="f")),
                                            ", p = ", .(formatC(res1$QEp, digits=2, format="f")), "; ", I^2, " = ",
                                            .(formatC(res1$I2, digits=1, format="f")), "%)")))

text(-161, 1, pos=4, cex=0.75, bquote(paste("RE Model subgroup (Q = ",
                                            .(formatC(res2$QE, digits=2, format="f")),
                                            ", p = ", .(formatC(res2$QEp, digits=2, format="f")), "; ", I^2, " = ",
                                            .(formatC(res2$I2, digits=1, format="f")), "%)")))



