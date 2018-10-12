package tdd.training.paf;

/**
 * Created by Administrator on 15.3.2016.
 */
public class CellContent {
    private String stringContent;
    private int intContent;
    private String formula;

    private CellTypes cellType;

    public CellContent(String content) {
        if (content.startsWith("=")) {
            this.formula = content;
            cellType = CellTypes.FORMULA;
        } else if (content.matches("[0-9]+")) {
            this.intContent = Integer.parseInt(content);
            cellType = CellTypes.NUMBER;
        } else {
            this.stringContent = "'" + content + "'";
            cellType = CellTypes.STRING;
        }
    }

    public CellTypes getCellType() {
        return this.cellType;
    }

    public String getStringContent() {
        return stringContent;
    }

    public int getIntContent() {
        return intContent;
    }

    public String getFormula() {
        return formula;
    }
}
