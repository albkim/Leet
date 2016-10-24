package leetcode.questions.dp;

import java.util.Arrays;

/**
 Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most two transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

 -----------------------------------------------------------------------------------------------------------------

 I wonder if we can do this. Since we can only make two transactions, which cannot overlap, perhaps we can create two pass
 for best time to buy sell stock from 0 - x and x + 1 - end

 Apparently it's also okay to do 1 transaction

 */
public class Best_Time_Buy_Sell_Stock_III_123 {

    public static int maxProfit(int[] prices) {
        if ((prices == null) || (prices.length < 2)) {
            // not enough to do even 1 transaction
            return 0;
        }

        int[] buy = new int[3], sell = new int[3];

        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int price : prices) {
            for (int i = 1; i <= 2; i++) {
                // maximum profit if I was to buy at this price. It's either not buying (buy[i] which takes previous vlaue)
                // or buying (sell[i - 1] - price which is max profit from last sale - current price)
                buy[i] = Math.max(buy[i], sell[i - 1] - price);

                // maximum profit if I was to sell at this price. It's either not selling (sell[i] which takes previous value)
                // or selling (max profit from last buy and the profit from this sale)
                sell[i] = Math.max(sell[i], buy[i] + price);
            }
        }
        return sell[2];
    }

}
