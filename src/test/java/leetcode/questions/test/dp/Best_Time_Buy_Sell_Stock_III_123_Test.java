package leetcode.questions.test.dp;

import leetcode.questions.dp.Best_Time_Buy_Sell_Stock_III_123;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/3/2016.
 */
public class Best_Time_Buy_Sell_Stock_III_123_Test {

    @Test
    public void testEdge() {
        assertEquals(1, Best_Time_Buy_Sell_Stock_III_123.maxProfit(new int[] {1,2}));
    }

    @Test
    public void testSimple() {
        assertEquals(6, Best_Time_Buy_Sell_Stock_III_123.maxProfit(new int[] {3,3,5,0,0,3,1,4}));
    }

}
