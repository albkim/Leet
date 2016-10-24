package leetcode.questions.back_tracking;

import java.util.*;

/**
 Given a collection of number that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:

 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]

 */
public class Permutations_II_47 {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // need to sort to ensure we don't use dupes
        Arrays.sort(nums);

        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);

        return result;
    }

    private static void backtrack(List<List<Integer>> result, ArrayList<Integer> current, int[] nums, boolean[] used) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
        }
        else {
            Integer previous = null;
            for (int index = 0; index < nums.length; index++) {
                if ((used[index] == true) || ((previous != null) && (previous == nums[index]))) {
                    continue;
                }
                current.add(nums[index]);
                used[index] = true;

                backtrack(result, current, nums, used);

                current.remove(current.size() - 1);
                used[index] = false;
                previous = nums[index];
            }
        }
    }

}
