package tdd.training.paf;

/**
 * Created by Administrator on 15.3.2016.
 */
public class Cell {
    private String address;
    private CellContent content;

    public Cell(String address, String content) {
        this.address = address;
        this.content = new CellContent(content);
    }

    public String getAddress() {
        return address;
    }

    public String getContent() {
        switch (this.content.getCellType()) {
            case STRING:
                return content.getStringContent();
            case FORMULA:
                return content.getFormula();
                break;
        }
        return null;
    }

    public int getIntContent() {
        return this.content.getIntContent();
    }

    public void setContent(String content) {
        this.content = new CellContent(content);
    }
}
