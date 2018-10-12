package tdd.training.paf;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSpreadSheet {
	
	SpreadSheet sheet = new SpreadSheet();

	@Test
	public void testSetCellWithValidContentData() {

		sheet.set("A1", "'frfr'");
		assertEquals("'frfr'", sheet.get("A1"));
		
		sheet.set("A2", "25");
		assertEquals("25", sheet.get("A2"));
		
		sheet.set("A3", "=34*4+16");
		assertEquals("=34*4+16", sheet.get("A3"));
	}
	
	@Test
	public void testSetCellWithNotValidContentData() {
		
		sheet.set("A1", "frfr");
		assertEquals("", sheet.get("A1"));
		
		sheet.set("A2", "25.43");
		assertEquals("", sheet.get("A2"));
	}

}
