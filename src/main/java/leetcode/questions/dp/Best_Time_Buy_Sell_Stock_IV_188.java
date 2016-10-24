package leetcode.questions.dp;

import java.util.Arrays;

/**
 Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most k transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

 --------------------------------------------------------------------------------------------------------------

 dp of the following:
 buy[i] = max(buy[i - 1],

 */
public class Best_Time_Buy_Sell_Stock_IV_188 {

    public static int maxProfit(int k, int[] prices) {
        // basic check
        if (k >= (prices.length / 2)) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }

        int[] buy = new int[k + 1], sell = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int price : prices) {
            for (int i = 1; i <= k; i++) {
                // maximum profit if I was to buy at this price. It's either not buying (buy[i] which takes previous vlaue)
                // or buying (sell[i - 1] - price which is max profit from last sale - current price)
                buy[i] = Math.max(buy[i], sell[i - 1] - price);

                // maximum profit if I was to sell at this price. It's either not selling (sell[i] which takes previous value)
                // or selling (max profit from last buy and the profit from this sale)
                sell[i] = Math.max(sell[i], buy[i] + price);
            }
        }
        return sell[k];
    }

}
