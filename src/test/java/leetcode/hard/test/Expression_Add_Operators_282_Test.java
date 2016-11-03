package leetcode.hard.test;

import leetcode.hard.Expression_Add_Operators_282;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/16/2016.
 */
public class Expression_Add_Operators_282_Test {

    @Test
    public void testSimple() {
        List<String> result = Expression_Add_Operators_282.addOperators("123", 6);

        assertEquals(2, result.size());

        assertEquals("1+2+3", result.get(0));
        assertEquals("1*2*3", result.get(1));
    }

    @Test
    public void testSimple1() {
        List<String> result = Expression_Add_Operators_282.addOperators("232", 8);

        assertEquals(2, result.size());

        assertEquals("2+3*2", result.get(0));
        assertEquals("2*3+2", result.get(1));
    }

    @Test
    public void testSimple2() {
        List<String> result = Expression_Add_Operators_282.addOperators("105", 5);

        assertEquals(2, result.size());

        assertEquals("1*0+5", result.get(0));
        assertEquals("10-5", result.get(1));
    }

    @Test
    public void testSimple3() {
        List<String> result = Expression_Add_Operators_282.addOperators("00", 0);

        assertEquals(3, result.size());

        assertEquals("0+0", result.get(0));
        assertEquals("0-0", result.get(1));
        assertEquals("0*0", result.get(2));
    }

    @Test
    public void testEdge() {
        List<String> result = Expression_Add_Operators_282.addOperators("3456237490", 9191);

        assertEquals(0, result.size());
    }

    @Test
    public void testComplex() {
        List<String> result = Expression_Add_Operators_282.addOperators("123456789", 45);

        assertEquals(121, result.size());
    }

}
