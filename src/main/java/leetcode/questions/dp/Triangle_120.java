package leetcode.questions.dp;

import java.util.List;

/**
 Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle

 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]



 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 Note:
 Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

 --------------------------------------------------------------------------------------------------------------

 Simple backtrack - but too slow

 I think this can be also done via DP. If we try to find the minimum sum from the bottom last and scan left and put 2 smallest
 [11]
 [9]
 [6,10]
 [1,1,3]

 [-1]
 [3,2]      ->    [0] min(3 + -3, 2, -1)
 [-3,1,-1]        [-3,-1]
 */
public class Triangle_120 {

    private static class Result {
        public int sum;
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

        return minimumTotalDP(triangle);
        // return minimumTotalBacktrack(triangle);
    }

    private static int minimumTotalDP(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][];

        for (int row = triangle.size() - 1; row > 0; row--) {
            dp[row] = new int[triangle.size() - 1];
            for (int column = 0; column < triangle.get(row).size() - 1; column++) {
                int current = triangle.get(row).get(column);
                int next = triangle.get(row).get(column + 1);
                if (row + 1 < triangle.size()) {
                    current += dp[row + 1][column];
                    next += dp[row + 1][column + 1];
                }
                dp[row][column] = Math.min(current, next);
            }
        }

        return dp[1][0] + triangle.get(0).get(0);
    }

    private static int minimumTotalBacktrack(List<List<Integer>> triangle) {
        Result result = new Result();
        result.sum = Integer.MAX_VALUE;

        backtrack(triangle, 0, 0, triangle.get(0).get(0), result);

        return result.sum;
    }

    private static void backtrack(List<List<Integer>> triangle, int row, int column, int sum, Result result) {
        if (row == triangle.size() - 1) {
            // last row, see if this sum is the min
            result.sum = Math.min(result.sum, sum);
            return;
        }

        List<Integer> nextRow = triangle.get(row + 1);
        for (int candidate = column; candidate <= Math.min(column + 1, nextRow.size() - 1); candidate++) {
            sum += nextRow.get(candidate);
            backtrack(triangle, row + 1, candidate, sum, result);
            sum -= nextRow.get(candidate);
        }
    }

}
