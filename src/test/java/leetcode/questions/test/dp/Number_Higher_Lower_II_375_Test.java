package leetcode.test.questions.dp;

import leetcode.questions.dp.Number_Higher_Lower_II_375;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by albertk on 8/25/16.
 */
public class Number_Higher_Lower_II_375_Test {

    @Test
    public void testValidRecursive() {
        assertEquals(0, Number_Higher_Lower_II_375.getMoneyAmountRecursive(1));
        assertEquals(4, Number_Higher_Lower_II_375.getMoneyAmountRecursive(4));
        assertEquals(6, Number_Higher_Lower_II_375.getMoneyAmountRecursive(5));
    }

    @Test
    public void testValidDP() {
        //assertEquals(0, Number_Higher_Lower_II_375.getMoneyAmountDP(1));
        //assertEquals(4, Number_Higher_Lower_II_375.getMoneyAmountDP(4));
        //assertEquals(6, Number_Higher_Lower_II_375.getMoneyAmountDP(5));
        assertEquals(49, Number_Higher_Lower_II_375.getMoneyAmountDP(20));
    }

}
