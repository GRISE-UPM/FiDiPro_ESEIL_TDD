package tdd.training.paf.content;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static tdd.training.paf.content.CellContentType.*;
import static tdd.training.paf.content.CellContentType.FORMULA;

/**
 * Created by Administrator on 15.3.2016.
 */
public class TestCell {

    @Test
    public void testSetContent_Number() {
        Cell cell = new Cell("");
        cell.setContent("0");
        assertEquals(NUMBER, cell.getContentType());
    }

    @Test
    public void testSetContent_String() {
        Cell cell = new Cell("");
        cell.setContent("0.0");
        assertEquals(STRING, cell.getContentType());
    }

    @Test
    public void testSetContent_Formula() {
        Cell cell = new Cell("");
        cell.setContent("=0");
        assertEquals(FORMULA, cell.getContentType());
    }
}
