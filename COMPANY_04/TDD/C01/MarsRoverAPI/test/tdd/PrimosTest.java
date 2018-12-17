/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tdd;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author uda
 */
public class PrimosTest {
    
    public PrimosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of lista method, of class Primos.
     */
    @Test
    public void testLista() {
        System.out.println("lista");
        int numero = 0;
        ArrayList expResult = null;
        ArrayList result = Primos.lista(numero);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     
    }

    /**
     * Test of descomponer method, of class Primos.
     */
    @Test
    public void testDescomponer() {
        System.out.println("descomponer");
        ArrayList<Integer> primos = null;
        int numero = 0;
        Primos.descomponer(primos, numero);
        // TODO review the generated test code and remove the default call to fail.
     
    }

    /**
     * Test of siguientePrimo method, of class Primos.
     */
    @Test
    public void testSiguientePrimo() {
        System.out.println("siguientePrimo");
        int valor = 21;
        int expResult = 3;
        int result = Primos.siguientePrimo(valor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of main method, of class Primos.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Primos.main(args);
        // TODO review the generated test code and remove the default call to fail.
     
    }
}
