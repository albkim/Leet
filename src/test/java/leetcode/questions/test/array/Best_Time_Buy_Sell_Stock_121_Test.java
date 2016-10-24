package leetcode.questions.test.array;

import leetcode.questions.array.Best_Time_Buy_Sell_Stock_121;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/3/2016.
 */
public class Best_Time_Buy_Sell_Stock_121_Test {

    @Test
    public void testSimple() {
        assertEquals(5, Best_Time_Buy_Sell_Stock_121.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
        assertEquals(0, Best_Time_Buy_Sell_Stock_121.maxProfit(new int[] {7, 6, 4, 3, 1}));
    }

}
