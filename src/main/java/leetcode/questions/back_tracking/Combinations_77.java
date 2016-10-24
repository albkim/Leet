package leetcode.questions.back_tracking;

import java.util.ArrayList;
import java.util.List;

/**
 Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:
 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]


 -------------------------------------------------------------------------------------

 Simple backtracking problem

 */
public class Combinations_77 {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, new ArrayList<Integer>(), n, 1, k);

        return result;
    }

    private static void backtrack(List<List<Integer>> result, ArrayList<Integer> integers, int n, int i, int k) {
        if (integers.size() == k) {
            result.add(new ArrayList<>(integers));
            return;
        }

        for (int number = i; number <= n; number++) {
            integers.add(number);

            backtrack(result, integers, n, number + 1, k);

            integers.remove(integers.size() - 1);
        }
    }

}
