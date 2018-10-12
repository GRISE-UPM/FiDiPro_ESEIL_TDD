package tdd.training.paf;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import javax.script.ScriptException;

public class TestSpreadSheet {

	@Test
	public void testSimpleNumericExpression() throws Exception {

		SpreadSheet ss = new SpreadSheet();
		long val = ss.evaluate("2+3*4");
		assertEquals(14, val);
	}

	@Test
	public void testExpwithCell() throws Exception {

		SpreadSheet ss = new SpreadSheet();
		long val = ss.evaluate("2+B2*A1");
		assertEquals(44, val);
	}

	@Test
	public void testExpwithequalsign() throws Exception {

		SpreadSheet ss = new SpreadSheet();
		long val = ss.evaluate("=2+B0+A1*C1");
		assertEquals(70, val);
	}

	@Ignore
	@Test
	public void testExpwithemptyCell() throws Exception {

		SpreadSheet ss = new SpreadSheet();
		long val = ss.evaluate("2+B2*C2");

	}

}
