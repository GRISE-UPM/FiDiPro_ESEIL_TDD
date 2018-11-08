package tdd.training.paf.operations;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 15.3.2016.
 */
public class TestFormulaCalculator {

    @Test
    public void testFormula_Invalid() {
        assertEquals(FormulaCalculator.Section.FORMULA_START, FormulaCalculator.Section.getSection("=start"));
    }
}
