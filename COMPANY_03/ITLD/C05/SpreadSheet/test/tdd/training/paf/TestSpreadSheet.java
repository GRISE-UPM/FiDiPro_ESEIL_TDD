package tdd.training.paf;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSpreadSheet {

	@Test
	public void testGetCell() {
		SpreadSheet sheet = new SpreadSheet();
		sheet.set("A1", "Content A1");
		String cellContent = sheet.get("A1");
		assertNotNull("Cell content shouldn't be null", cellContent);
		assertEquals("Wrong content.", "Content A1", cellContent);

	}

	@Test
	public void testSetCell() {
		SpreadSheet sheet = new SpreadSheet();
		String cellContent = "SetContent A1";
		sheet.set("A1", cellContent);
		assertEquals("Wrong content returned.", cellContent, sheet.get("A1"));
	}

	@Test
	public void testSeveralCells() {
		SpreadSheet sheet = new SpreadSheet();
		String cellContent = "SetContent A1";
		sheet.set("A1", cellContent);
		String cellContent2 = "SetContent B2";
		sheet.set("B2", cellContent2);
		sheet.set("E69","Content 69");
		sheet.set("JS56", "Content JS56");

		String response1 = sheet.get("A1");
		String response2 = sheet.get("B2");
		assertNotEquals("These two cells should have different content.", response1, response2);

	}

	@Test
	public void testArbitraryAddresses() {
		SpreadSheet sheet = new SpreadSheet();
		sheet.set("B52", "Bomber");
		sheet.set("E69","Content 69");
		sheet.set("JS56", "Content JS56");
		assertEquals("Wrong content.", "Bomber", sheet.get("B52"));
		assertEquals("Wrong content.", "Content 69", sheet.get("E69"));
		assertEquals("Wrong content.", "Content JS56", sheet.get("JS56"));
	}

	@Test
	public void testUnusedAddresses() {
		SpreadSheet sheet = new SpreadSheet();
		String response = sheet.get("F5");
		assertNull("There shouldn't be any content.", response);

	}
}
