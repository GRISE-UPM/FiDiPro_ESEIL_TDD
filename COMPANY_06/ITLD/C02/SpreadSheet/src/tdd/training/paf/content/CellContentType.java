package tdd.training.paf.content;


/**
 * Created by Administrator on 15.3.2016.
 */
public enum CellContentType {
    EMPTY, NUMBER, STRING, FORMULA, INVALID;

    public static CellContentType evaluateContentType(String content) {
        if (content != null) {
            String _content = content.trim();
            if (_content.length() > 0) {
                if (_content.startsWith("=")) {
                    return FORMULA;
                }
                try {   // todo: verify if regex would be better here
                    Integer.valueOf(_content);
                    return NUMBER;
                }
                catch (NumberFormatException nfe) {
                    return STRING;
                }
            }
            return EMPTY;
        }
        return INVALID;
    }
}
