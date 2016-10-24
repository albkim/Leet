package leetcode.questions.back_tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 Given a collection of integers that might contain duplicates, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,2], a solution is:
 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]


 --------------------------------------------------------------------------------------------------------

 Similar to combination sum II where we sort and do some previous check when back tracking

 */
public class Subsets_II_90 {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int length = 0; length <= nums.length; length++) {
            backtrack(result, nums, new ArrayList<>(), 0, length);
        }

        return result;
    }

    private static void backtrack(List<List<Integer>> result, int[] nums, List<Integer> current, int start, int length) {
        if (current.size() == length) {
            result.add(new ArrayList<>(current));
            return;
        }

        Integer previous = null;
        for (int index = start; index < nums.length; index++) {
            if ((previous != null) && (previous.intValue() == nums[index])) {
                // dupe skip
                continue;
            }

            current.add(nums[index]);
            backtrack(result, nums, current, index + 1, length);
            current.remove(current.size() - 1);

            previous = nums[index];
        }
    }

}
