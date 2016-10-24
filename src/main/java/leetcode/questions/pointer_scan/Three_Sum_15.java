package leetcode.questions.pointer_scan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note: The solution set must not contain duplicate triplets.
 For example, given array S = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]

Seems like 2 sum + 2 sum (iterative)
 */
public class Three_Sum_15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        // need to sort it first
        Arrays.sort(nums);

        Integer previous = null;
        List<List<Integer>> result = new ArrayList<>();
        // iterate from left to right (we can skip the last two since they can only be part of the other two)
        for (int index = 0; index < (nums.length - 2); index++) {
            // once we evaluate a number, no need to go back since we don't allow dupes, left number should have
            // been covered by previous iteration

            // also need to skip this number if it's same as previous since it will also create dupes
            if ((previous != null) && (previous.intValue() == nums[index])) {
                continue;
            }

            previous = nums[index];
            int remainder = 0 - nums[index];

            int left = index + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                boolean moveRight = false;
                if (sum == remainder) {
                    // we found it
                    result.add(Arrays.asList(nums[index], nums[left], nums[right]));
                    moveRight = true;
                }
                else if (sum < remainder) {
                    moveRight = true;
                }

                if (moveRight) {
                    int currentLeft = nums[left];
                    do {
                        left++;
                    }
                    while((left < right) && (nums[left] == currentLeft));
                }
                else {
                    int currentRight = nums[right];
                    do {
                        right--;
                    }
                    while((left < right) && (nums[right] == currentRight));
                }
            }
        }
        return result;
    }

}
