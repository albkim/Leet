package leetcode.questions.dp;

/**
 You are given coins of different denominations and a total amount of money amount.
 Write a function to compute the fewest number of coins that you need to make up that amount.
 If that amount of money cannot be made up by any combination of the coins, return -1.

 Example 1:
 coins = [1, 2, 5], amount = 11
 return 3 (11 = 5 + 5 + 1)

 Example 2:
 coins = [2], amount = 3
 return -1.

 Note:
 You may assume that you have an infinite number of each kind of coin.

 -------------------------------------------------------------------------------------------

 Seems like a classic backtracking & dp problem. Try with backtracking first and then dp.

 */
public class Coin_Change_322 {

    public static int coinChange(int[] coins, int amount) {
        if ((coins == null) || (coins.length == 0)) {
            return -1;
        }

        // int times = backtrack(coins, amount, 0);
        int times = dp(coins, amount);
        if (times == Integer.MAX_VALUE) {
            return -1;
        }
        return times;
    }

    private static int dp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        // now build up the dp from lowest amount
        for (int index = 1; index <= amount; index++) {
            int min = Integer.MAX_VALUE;
            for (int denomination : coins) {
                if (index == denomination) {
                    min = 1;
                }
                else if (index > denomination) {
                    if (dp[index - denomination] != Integer.MAX_VALUE) {
                        min = Math.min(min, 1 + dp[index - denomination]);
                    }
                }
            }
            dp[index] = min;
        }

        return dp[amount];
    }

    private static int backtrack(int[] coins, int amount, int count) {
        if (amount == 0) {
            return count;
        }

        int min = Integer.MAX_VALUE;
        for(int denomination : coins) {
            if (amount - denomination >= 0) {
                min = Math.min(min, backtrack(coins, amount - denomination, count + 1));
            }
        }
        return min;
    }

}
