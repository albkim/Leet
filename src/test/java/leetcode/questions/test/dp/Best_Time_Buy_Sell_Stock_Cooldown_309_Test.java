package leetcode.questions.test.dp;

import leetcode.questions.dp.Best_Time_Buy_Sell_Stock_Cooldown_309;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/18/2016.
 */
public class Best_Time_Buy_Sell_Stock_Cooldown_309_Test {

    @Test
    public void testEdge() {
        assertEquals(0, Best_Time_Buy_Sell_Stock_Cooldown_309.maxProfit(new int[] {1}));
    }

    @Test
    public void testSimple() {
        assertEquals(3, Best_Time_Buy_Sell_Stock_Cooldown_309.maxProfit(new int[] {1, 2, 3, 0, 2}));
    }

    @Test
    public void testSimple1() {
        assertEquals(3, Best_Time_Buy_Sell_Stock_Cooldown_309.maxProfit(new int[] {2, 1, 4}));
    }

}
