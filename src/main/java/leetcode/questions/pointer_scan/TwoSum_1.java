package leetcode.questions.pointer_scan;

import java.util.HashMap;
import java.util.Map;

/**
 Given an array of integers, return indices of the two number such that they add up to a specific target.

 You may assume that each input would have exactly one solution.

 Example:

 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].

 If there is no requirement around space, use a map and search for sum - current = remainder
 If there is requirement around space, sort and as the left point moves, move the right pointer
    the premise here is that you can only move one direction in order to be below the sum
 */
public class TwoSum_1 {

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }

        Map<Integer, Integer> lookup = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            int remainder = target - nums[index];
            if (lookup.containsKey(remainder)) {
                return new int[] { lookup.get(remainder), index };
            }
            lookup.put(nums[index], index);
        }

        // since it's guaranteed to have exactly one solution, we shouldn't be here
        throw new IllegalStateException();
    }

}
