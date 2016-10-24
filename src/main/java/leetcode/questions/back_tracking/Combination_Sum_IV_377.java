package leetcode.questions.back_tracking;

import java.util.HashMap;
import java.util.Map;

/**
 Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add
 up to a positive integer target.
 Example:
 nums = [1, 2, 3]
 target = 4

 The possible combination ways are:
 (1, 1, 1, 1)
 (1, 1, 2)
 (1, 2, 1)
 (1, 3)
 (2, 1, 1)
 (2, 2)
 (3, 1)

 Note that different sequences are counted as different combinations.

 Therefore the output is 7.

 Follow up: 
 What if negative numbers are allowed in the given array? 
 How does it change the problem?   Yes
 What limitation we need to add to the question to allow negative numbers?
    cannot have opposite being used together forever
    1, -1 and repeat forever and always create 0


 ---------------------------------------------------------------------------------------------------

 
 Seems like we can use integer partitioning here just that I need to only use available numbers and not do is number
 greater than previous check to include dupes (different sequences)

 */
public class Combination_Sum_IV_377 {

    public static int combinationSum4Recursive(int[] nums, int target) {
        int count = 0;

        for (int index = 0; index < nums.length; index++) {
            int remainder = target - nums[index];
            if (remainder == 0) {
                count++;
            }
            else if (remainder > 0) {
                count += combinationSum4Recursive(nums, remainder);
            }
        }

        return count;
    }

    public static int combinationSum4Memoization(int[] nums, int target) {
        return combinationSum4MemoizationI(new HashMap<Integer, Integer>(), nums, target);
    }

    private static int combinationSum4MemoizationI(Map<Integer, Integer> lookup, int[] nums, int target) {
        int count = 0;

        for (int index = 0; index < nums.length; index++) {
            int remainder = target - nums[index];
            if (remainder == 0) {
                count++;
            }
            else if (remainder > 0) {
                if (lookup.containsKey(remainder)) {
                    count += lookup.get(remainder);
                }
                else {
                    count += combinationSum4MemoizationI(lookup, nums, remainder);
                }
            }
        }

        if (!lookup.containsKey(target)) {
            lookup.put(target, count);
        }

        return count;
    }

}
