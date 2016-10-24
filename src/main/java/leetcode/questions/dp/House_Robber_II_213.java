package leetcode.questions.dp;

/**
 Note: This is an extension of House Robber.

 After robbing those houses on that street, the thief has found himself a new place for his thievery
 so that he will not get too much attention. This time, all houses at this place are arranged in a circle.
 That means the first house is the neighbor of the last one. Meanwhile, the security system for these
 houses remain the same as for those in the previous street.

 Given a list of non-negative integers representing the amount of money of each house,
 determine the maximum amount of money you can rob tonight without alerting the police.

 ---------------------------------------------------------------------------------------------------------

 Since it wraps there are two cases:

   If first house is robbed we cannot rob the last house, so the dp has to stop at n - 1
   If first house is not robbed (we start from index 1) then we can do all the way.

 Max is max of the two cases


 */
public class House_Robber_II_213 {

    public static int rob(int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[nums.length + 1];

        // first case
        for (int index = 0; index < nums.length - 1; index++) {
            // need empty first 2 elements
            int dpIndex = index + 2;
            dp[dpIndex] = Math.max(dp[dpIndex - 1], dp[dpIndex - 2] + nums[index]);
        }

        int max1 = dp[nums.length];

        // second case
        for (int index = 1; index < nums.length; index++) {
            // need empty first 2 elements
            int dpIndex = index + 1;
            dp[dpIndex] = Math.max(dp[dpIndex - 1], dp[dpIndex - 2] + nums[index]);
        }

        int max2 = dp[nums.length];

        return Math.max(max1, max2);
    }

}
