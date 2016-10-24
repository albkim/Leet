package leetcode.questions.back_tracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 Given a collection of distinct number, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:

 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]

 recursive
 1 => (1, 2), (1, 3) => (1, 2, 3), (1, 3, 2)
 2 => (2, 1), (2, 3) => (2, 1, 3), (2, 3, 1)
 3 => (3, 1), (3, 2) => (3, 1, 2), (3, 2, 1)
 */
public class Permutations_46 {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);

        return result;
    }

    private static void backtrack(List<List<Integer>> result, ArrayList<Integer> current, int[] nums, boolean[] used) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
        }
        else {
            for (int index = 0; index < nums.length; index++) {
                if (used[index] == true) {
                    continue;
                }
                current.add(nums[index]);
                used[index] = true;

                backtrack(result, current, nums, used);

                current.remove(current.size() - 1);
                used[index] = false;
            }
        }
    }

}
