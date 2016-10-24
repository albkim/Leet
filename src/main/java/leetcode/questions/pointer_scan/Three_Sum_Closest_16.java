package leetcode.questions.pointer_scan;

import java.util.Arrays;

/**
 Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 Return the sum of the three integers. You may assume that each input would have exactly one solution.
 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 Seems like 3 sum with min diff tracking
 */
public class Three_Sum_Closest_16 {

    public static int threeSumClosest(int[] nums, int target) {
        // need to sort it first
        Arrays.sort(nums);

        int result = 0;
        int minDiff = Integer.MAX_VALUE;
        // iterate from left to right (we can skip the last two since they can only be part of the other two)
        for (int index = 0; index < (nums.length - 2); index++) {
            // once we evaluate a number, no need to go back since we don't allow dupes, left number should have
            // been covered by previous iteration

            int remainder = target - nums[index];

            int left = index + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == remainder) {
                    // this is the closest
                    return target;
                }

                int diff = Math.abs(target - (nums[index] + sum));
                if (diff < minDiff) {
                    minDiff = diff;
                    result = nums[index] + sum;
                }
                if (sum < remainder) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return result;
    }

}
