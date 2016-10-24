package leetcode.questions.back_tracking;

import java.util.*;

/**
 Given a set of candidate number (C) and a target number (T), find all unique combinations in C where the candidate number sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:

 •All number (including target) will be positive integers.
 •The solution set must not contain duplicate combinations.


 For example, given candidate set [2, 3, 6, 7] and target 7,
 A solution set is:

 [
 [7],
 [2, 2, 3]
 ]

 integer partitioning with constraint on number to use
 */
public class Combination_Sum_39 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            for (int index = currentIndex; index >= 0; index--) {
                int candidate = candidates[index];

                current.add(candidate);
                // pass index since we can reuse the same element (2,2,3 in above example)
                backtrack(result, current, candidates, index, target - candidate);
                current.remove(current.size() - 1);
            }
        }
    }

}
