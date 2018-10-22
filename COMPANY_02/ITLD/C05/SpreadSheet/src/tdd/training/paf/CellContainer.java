package tdd.training.paf;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Administrator on 15.3.2016.
 */
public class CellContainer {
    Map<String, Cell> cells;

    public CellContainer() {
        cells = new HashMap<String, Cell>();
    }

    public Cell getCell(String address) {
        return cells.get(address);
    }

    public void addCell(Cell cell) {
        cells.put(cell.getAddress(), cell);
    }
}
