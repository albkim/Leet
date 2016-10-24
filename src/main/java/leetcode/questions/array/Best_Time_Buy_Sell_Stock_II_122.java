package leetcode.questions.array;

/**
 Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple
 transactions at the same time (ie, you must sell the stock before you buy again).

 ------------------------------------------------------------------------------------------------------------------

 If I add all increasing price, it's same as buying at the bottom and then selling at the top

 */
public class Best_Time_Buy_Sell_Stock_II_122 {

    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

}
