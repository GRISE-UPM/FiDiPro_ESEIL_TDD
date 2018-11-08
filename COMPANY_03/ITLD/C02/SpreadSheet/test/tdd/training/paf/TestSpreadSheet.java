package tdd.training.paf;

import static org.junit.Assert.*;

import org.junit.Test;
import tdd.training.paf.content.CellContentType;
import tdd.training.paf.exceptions.Errors;

public class TestSpreadSheet {

	//todo: migrate this to test data
	private static final String CELL_NAME_A1 = "A1";
	private static final String CONTENT_STRING = "any string";
	private static final String CONTENT_NUMBER = "1";
	private static final String CONTENT_FORMULA = "=1";

	@Test
	public void testGetCell() {
		SpreadSheet spreadSheet = new SpreadSheet();
		assertNull(spreadSheet.get(CELL_NAME_A1));
	}

	@Test
	public void testSetCell() {
		SpreadSheet spreadSheet = new SpreadSheet();
		spreadSheet.set(CELL_NAME_A1, CONTENT_STRING);
		assertTrue(spreadSheet.has(CELL_NAME_A1));
		assertNotNull(spreadSheet.get(CELL_NAME_A1));
	}

	@Test
	public void testSetCellContentNotNull() {
		SpreadSheet spreadSheet = new SpreadSheet();
		spreadSheet.set(CELL_NAME_A1, CONTENT_STRING);
		assertEquals(CONTENT_STRING, spreadSheet.get(CELL_NAME_A1));
	}

	@Test
	public void testEvaluate_no_cell() {
		SpreadSheet spreadSheet = new SpreadSheet();
		assertEquals(Errors.ERROR.errorName, spreadSheet.evaluate(CELL_NAME_A1));
	}

	@Test
	public void testEvaluate_Number() {
		SpreadSheet spreadSheet = new SpreadSheet();
		spreadSheet.set(CELL_NAME_A1, CONTENT_NUMBER);
		assertEquals(CONTENT_NUMBER, spreadSheet.evaluate(CELL_NAME_A1));
	}

	@Test
	public void testEvaluate_String() {
		SpreadSheet spreadSheet = new SpreadSheet();
		spreadSheet.set(CELL_NAME_A1, CONTENT_STRING);
		assertEquals(CONTENT_STRING, spreadSheet.evaluate(CELL_NAME_A1));
	}

	@Test
	public void testEvaluate_Formula() {
		SpreadSheet spreadSheet = new SpreadSheet();
		spreadSheet.set(CELL_NAME_A1, CONTENT_FORMULA);
		assertEquals("undefined", spreadSheet.evaluate(CELL_NAME_A1));
	}
}
