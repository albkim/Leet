package leetcode.questions.dp;

/**
 Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums.
 You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
 Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

 Find the maximum coins you can collect by bursting the balloons wisely.

 Note:
 (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 (2) 0 ? n ? 500, 0 ? nums[i] ? 100

 Example:

 Given [3, 1, 5, 8]

 Return 167
 nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167

----------------------------------------------------------------------------------------------------------------

 Seems like the simpliest way is to backtrack. Let me try that...

 TLE...try dp

 In order to DP, we need to identify a sub problem which does not depend on previous state so we can bottom up.
 If we decide pop and adjust size of the array, it doesn't work because popping a balloon impacts product afterwards
 (neighbors now can be multiplied). So what if we consider the last balloon.

 Consider array of length 1 where each balloon is the last one
        0       1       2       3
    0  1*3*1
    1         3*1*5
    2                1*5*8
    3                         5*8*1

 Consider array of length 2 where each baloon is the last one
         0       1       2       3
    0  1*3*1    30
    1         3*1*5
    2                1*5*8
    3                         5*8*1

    0 - 1
        0 (1 is gone already) -> 1*3*5 + f(1,1) = 30
        1 (0 is gone already) -> f(0,0) + 1*1*5 = 8
    1 - 2
        1 -> 3*1*8 + f(2,2)
        2 -> f(1,1) + 3*5*8

    and so on.
    Now the final answer would be dp at 0, 3
 */
public class Burst_Balloons_312 {

    public static int maxCoins(int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return 0;
        }

        return dp(nums);
        // return backtrack(nums, new boolean[nums.length], 0);
    }

    private static int dp(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];

        for (int length = 0; length < nums.length; length++) {
            for (int i = 0; i < nums.length - length; i++) {
                int j = i + length;
                int max = Integer.MIN_VALUE;
                for (int index = i; index <= j; index++) {
                    int dpLeft = (index > i) ? dp[i][index - 1] : 0;
                    int dpRight = (index < j) ? dp[index + 1][j] : 0;
                    int left = (i > 0) ? nums[i - 1] : 1;
                    int right = (j < nums.length - 1) ? nums[j + 1] : 1;

                    int current = dpLeft + (left * nums[index] * right) + dpRight;
                    max = Math.max(max, current);
                }
                dp[i][j] = max;
            }
        }

        return dp[0][nums.length - 1];
    }

    private static int backtrack(int[] nums, boolean[] used, int usedNum) {
        if (nums.length == usedNum) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for (int index = 0; index < nums.length; index++) {
            if (!used[index]) {
                used[index] = true;
                int left = 1;
                for (int l = index - 1; l >= 0; l--) {
                    if (!used[l]) {
                        left = nums[l];
                        break;
                    }
                }
                int right = 1;
                for (int r = index + 1; r < nums.length; r++) {
                    if (!used[r]) {
                        right = nums[r];
                        break;
                    }
                }
                int current = left * nums[index] * right;
                max = Math.max(max, current + backtrack(nums, used, usedNum + 1));
                used[index] = false;
            }
        }
        return max;
    }

}
