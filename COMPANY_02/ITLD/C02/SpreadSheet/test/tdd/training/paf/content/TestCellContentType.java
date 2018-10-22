package tdd.training.paf.content;

import static org.junit.Assert.*;
import static tdd.training.paf.content.CellContentType.*;

import org.junit.Test;

/**
 * Created by Administrator on 15.3.2016.
 */
public class TestCellContentType {

    @Test
    public void testFormula() throws Exception {
        assertEquals(FORMULA, evaluateContentType("=unparseable"));
        assertNotEquals(FORMULA, evaluateContentType("unparseable"));
    }

    @Test
    public void testNumber() throws Exception {
        assertEquals(NUMBER, evaluateContentType("0"));
        assertEquals(NUMBER, evaluateContentType("1"));
        assertEquals(NUMBER, evaluateContentType("-1"));
        assertEquals(NUMBER, evaluateContentType("  1  "));
        assertEquals(NUMBER, evaluateContentType("  -1  "));
        assertNotEquals(NUMBER, evaluateContentType("1.1"));
    }

    @Test
    public void testString() throws Exception {
        assertEquals(STRING, evaluateContentType("0something"));
        assertEquals(STRING, evaluateContentType("1something else"));
        assertEquals(STRING, evaluateContentType("1.1"));
    }

}
