package tdd.training.paf.operations;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import tdd.training.paf.SpreadSheet;
import tdd.training.paf.exceptions.Errors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 15.3.2016.
 */
public class FormulaCalculator {

    public enum Section {
        INVALID(""),
        FORMULA_START("^(\\s*=\\s*)(.*)");

        public static Section getSection(String str) {
            for (Section section : values()) {
                if (section.getMatcher(str).matches()) {
                    return section;
                }
            }
            return INVALID;
        }

        private final Pattern pattern;
        Section(String regex) {
            this.pattern = Pattern.compile(regex);
        }
        public Matcher getMatcher(String str) {
            return pattern.matcher(str);
        }

        public String extract(String str){
            Matcher matcher = getMatcher(str);
            matcher.find();
            return matcher.group(1);
        }
    }

    public static String evaluate(String content, SpreadSheet spreadSheet) {
        int index = 0;
        while (index < content.length()) {
            String subsection = content.substring(index);
            Section section = Section.getSection(subsection);
            switch (section) {
                case FORMULA_START:
                    index += section.extract(subsection).length();
                case INVALID:
                    return Errors.ERROR.errorName;
            }
        }
        return "unimplemented";
    }
}
