package tdd.training.paf.exceptions;

/**
 * Created by Administrator on 15.3.2016.
 */
public enum Errors {
    ERROR("#Error"),
    CIRCULAR("#Circular");

    public final String errorName;
    Errors(String name) {
        this.errorName = name;
    }
}
