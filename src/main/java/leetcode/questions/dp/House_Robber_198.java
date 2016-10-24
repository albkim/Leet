package leetcode.questions.dp;

/**
 You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 the only constraint stopping you from robbing each of them is that adjacent houses have security system connected
 and it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house,
 determine the maximum amount of money you can rob tonight without alerting the police.

 -------------------------------------------------------------------------------------------------------------------

 We can track a DP for each house. The current max is max(f(n-2) + current, f(n-1)) which means either we steal this house
 (therefore we cannot steal from last house) or we still from last house and not steal from current

 */
public class House_Robber_198 {

    public static int rob(int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return 0;
        }

        int[] dp = new int[nums.length + 2];

        for (int index = 0; index < nums.length; index++) {
            // need empty first 2 elements
            int dpIndex = index + 2;
            dp[dpIndex] = Math.max(dp[dpIndex - 1], dp[dpIndex - 2] + nums[index]);
        }

        return dp[nums.length + 1];
    }

}
