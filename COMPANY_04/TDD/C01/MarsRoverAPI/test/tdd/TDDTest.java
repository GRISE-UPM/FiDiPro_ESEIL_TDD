/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tdd;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author uda
 */
public class TDDTest {
    
    public TDDTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of calcular method, of class TDD.
     */
    @Test
    public void testCalcular() {
        System.out.println("calcular");
        int valor = 0;
        int expResult = 0;
        int result = TDD.calcular(valor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class TDD.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        TDD.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
