package leetcode.questions.test.recursion;

import leetcode.questions.recursion.Different_Ways_Add_Parentheses_241;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/15/2016.
 */
public class Different_Ways_Add_Parentheses_241_Test {

    @Test
    public void testSimple() {
        List<Integer> result = Different_Ways_Add_Parentheses_241.diffWaysToCompute("2-1-1");

        assertEquals(2, result.size());
        assertEquals(2, result.get(0).intValue());
        assertEquals(0, result.get(1).intValue());
    }

    @Test
    public void testSimple1() {
        List<Integer> result = Different_Ways_Add_Parentheses_241.diffWaysToCompute("2*3-4*5");

        assertEquals(5, result.size());
        assertEquals(-34, result.get(0).intValue());
        assertEquals(-10, result.get(1).intValue());
        assertEquals(-14, result.get(2).intValue());
        assertEquals(-10, result.get(3).intValue());
        assertEquals(10, result.get(4).intValue());
    }

}
