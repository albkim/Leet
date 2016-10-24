package leetcode.questions.test.array;

import leetcode.questions.array.Best_Time_Buy_Sell_Stock_II_122;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/3/2016.
 */
public class Best_Time_Buy_Sell_Stock_II_122_Test {

    @Test
    public void testSimple() {
        assertEquals(0, Best_Time_Buy_Sell_Stock_II_122.maxProfit(new int[] {2,1}));
        assertEquals(1, Best_Time_Buy_Sell_Stock_II_122.maxProfit(new int[] {1,2}));
    }

    @Test
    public void testComplex() {
        assertEquals(3, Best_Time_Buy_Sell_Stock_II_122.maxProfit(new int[] {2,1,4}));
        assertEquals(3, Best_Time_Buy_Sell_Stock_II_122.maxProfit(new int[] {1,4,2}));
    }

}
