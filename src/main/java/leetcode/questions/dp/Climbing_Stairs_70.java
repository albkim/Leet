package leetcode.questions.dp;

/**
 You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?


 -------------------------------------------------------------------------------------------------


 Seems like a very simple DP

        1       2       3       4       5
                                        1
                                2
                        3 = f(4) + f(5)
                5 = f(3) + f(4)
        8 = f(2) + f(3)

 */
public class Climbing_Stairs_70 {

    public static int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[n] = 1;

        for (int index = n - 1; index >= 0; index--) {
            dp[index] = (((index + 1) <= n) ? dp[index + 1] : 0) + (((index + 2) <= n) ? dp[index + 2] : 0);
        }

        return dp[0];
    }

}
