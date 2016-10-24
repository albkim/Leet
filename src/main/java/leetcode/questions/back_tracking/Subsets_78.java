package leetcode.questions.back_tracking;

import java.util.ArrayList;
import java.util.List;

/**
 Given a set of distinct integers, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,3], a solution is:
 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]

----------------------------------------------------------------------------------------------


 Seems almost same as combination, just need to generate varying length

 */
public class Subsets_78 {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for (int length = 1; length <= nums.length; length++) {
            backtrack(result, new ArrayList<Integer>(), nums, 0, length);
        }

        result.add(new ArrayList<>());

        return result;
    }

    private static void backtrack(List<List<Integer>> result, ArrayList<Integer> integers, int[] nums, int startIndex, int k) {
        if (integers.size() == k) {
            result.add(new ArrayList<>(integers));
            return;
        }

        for (int index = startIndex; index < nums.length; index++) {
            integers.add(nums[index]);

            backtrack(result, integers, nums, index + 1, k);

            integers.remove(integers.size() - 1);
        }
    }

}
