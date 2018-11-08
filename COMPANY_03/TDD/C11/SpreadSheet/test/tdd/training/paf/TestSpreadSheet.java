package tdd.training.paf;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSpreadSheet {

	private SpreadSheet spreadSheet = new SpreadSheet();
	
	@Test
	public void testStoreContent() {
		spreadSheet.set("A1", "ABC");
		assertEquals("ABC",spreadSheet.getContent().get("A1"));
	}
	
	@Test
	public void testRetrieveContent(){
		spreadSheet.getContent().put("A1", "ABC");
		assertEquals("ABC", spreadSheet.get("A1"));
	}
	
	@Test
	public void testEvaluateSingleNumber(){
		spreadSheet.set("A1", "=1");
		assertEquals("1", spreadSheet.evaluate("A1"));
	}

	@Test
	public void testEvaluateAddition1add1(){
		spreadSheet.set("A1", "=1+1");
		String eval = spreadSheet.evaluate("A1");
		assertEquals("2", eval);
	}
	@Test
	public void testEvaluateAddition1add2(){
		spreadSheet.set("A1", "=1+2");
		String eval = spreadSheet.evaluate("A1");
		assertEquals("3", eval);
	}
	
	@Test
	public void testEvaluateAddition1addminus1add2(){
		spreadSheet.set("A1", "=1+-1+2");
		String eval = spreadSheet.evaluate("A1");
		assertEquals("2", eval);
	}
	
	@Test
	public void testEvaluateAddition1addminus1(){
		spreadSheet.set("A1", "=1+-1");
		String eval = spreadSheet.evaluate("A1");
		assertEquals("0", eval);
	}
}
