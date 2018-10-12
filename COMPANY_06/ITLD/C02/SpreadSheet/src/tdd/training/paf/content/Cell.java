package tdd.training.paf.content;

import static tdd.training.paf.content.CellContentType.*;

/**
 * Created by Administrator on 15.3.2016.
 */
public class Cell {

    public final String name;

    private String content;
    private CellContentType contentType = EMPTY;

    public Cell(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public CellContentType getContentType() {
        return contentType;
    }

    public void setContent(String content) {
        this.content = content;
        this.contentType = evaluateContentType(content);
    }
}
