package leetcode.questions.back_tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 Given a collection of candidate number (C) and a target number (T), find all unique combinations in C where the candidate number sums to T.

 Each number in C may only be used once in the combination.

 Note:

 •All number (including target) will be positive integers.
 •The solution set must not contain duplicate combinations.


 For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 A solution set is:

 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]

 */
public class Combination_Sum_II_40 {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        // sort candidates in desc order, this will ensure we don't have dupes
        Arrays.sort(candidates);

        backtrack(result, new ArrayList<>(), candidates, candidates.length - 1, target);

        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int currentIndex, int target) {
        if (target < 0) {
            return;
        }
        else if (target == 0) {
            result.add(new ArrayList<>(current));
        }
        else {
            Integer previous = null;
            for (int index = currentIndex; index >= 0; index--) {
                int candidate = candidates[index];
                if ((previous != null) && (previous.intValue() == candidate)) {
                    // same combination, skip
                    continue;
                }

                current.add(candidate);
                // we cannot reuse same element so index - 1
                backtrack(result, current, candidates, index - 1, target - candidate);
                current.remove(current.size() - 1);
                previous = candidate;
            }
        }
    }

}
