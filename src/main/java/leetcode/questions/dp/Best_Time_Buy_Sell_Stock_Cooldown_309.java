package leetcode.questions.dp;

/**
 Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 •You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 •After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)

 Example:

 prices = [1, 2, 3, 0, 2]
 maxProfit = 3
 transactions = [buy, sell, cooldown, buy, sell]

 -------------------------------------------------------------------------------------------------------

 Since there is one day cooldown, we may need to try selling if there is profit and then take a cooldown in a
 back tracking approach?....TLE

 We can try state machine. On any given day i, we can do one of the 4 (and it also limits what we can do on i-1)

    1. Sell stock
    2. Don't sell stock
    3. Buy stock
    4. Don't buy stock

 If we are doing 1 on day i, we have to have done either 2 or 3 (otherwise we won't have the stock to sell)
 So create a lookup
        i: 1 -> i-1: 2,3
        i: 2 -> i-1: 2,3
        i: 3 -> i-1: 4
        i: 4 -> i-1: 1,4

 As we iterate, we can try all 4 variations

 */
public class Best_Time_Buy_Sell_Stock_Cooldown_309 {

    public static int maxProfit(int[] prices) {
        if ((prices == null) || (prices.length < 2)) {
            return 0;
        }

        int case1 = 0;
        int case2 = -prices[0]; // need this since if we don't have stock, we would get the wrong calculation here
        int case3 = -prices[0];
        int case4 = 0;
        for (int index = 1; index < prices.length; index++) {
            int oldCase1 = case1;
            case1 = prices[index] + Math.max(case2, case3);
            case2 = Math.max(case2, case3);
            case3 = -prices[index] + case4;
            case4 = Math.max(oldCase1, case4);
        }

        return Math.max(case1, Math.max(case2, Math.max(case3, case4)));
    }

    private static int backtrack(int[] prices, int lastSold) {
        int max = 0;
        for (int buy = lastSold + 2; buy < prices.length - 1; buy++) {
            for (int sell = buy + 1; sell < prices.length; sell++) {
                // see if we have a profit
                int thisProfit = prices[sell] - prices[buy];
                if (thisProfit > 0) {
                    // if we sold today, we need to buy 2 days from now...only if we have enough days to buy & sell
                    if (sell + 3 < prices.length) {
                        thisProfit += backtrack(prices, sell);
                    }
                    max = Math.max(max, thisProfit);
                }
            }
        }
        return max;
    }

}
