package leetcode.questions.dp;

/**
 Given an integer matrix, find the length of the longest increasing path.

 From each cell, you can either move to four directions: left, right, up or down.
 You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

 Example 1:
 nums = [
 [9,9,4],
 [6,6,8],
 [2,1,1]
 ]

 Return 4
 The longest increasing path is [1, 2, 6, 9].

 Example 2:
 nums = [
 [3,4,5],
 [3,2,6],
 [2,2,1]
 ]

 Return 4
 The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

 ------------------------------------------------------------------------------------------------

 Seems like LIS with backtracking for simple solution. Perhaps once I do this, I can try with dp or something

 Dumb me it's not LIS...it's longest increasing continuous path...lol!

 So as expected, TLE. The tricky bit about memoizing or dp'ing is that what happened before can limit the path of traversal
 So it seems like the best I can do is find the longest path if the current node is the first. As long as that longest
 path does not include current, and current is smaller than neighbors. I can add it?
 Nope, don't need to worry about that, by definition (increasing) if current number can be additive, it couldn't have been
 used so it's very simple dp

 */
public class Longest_Increasing_Path_Matrix_329 {

    private static int[][] directions = new int[][] {
            new int[] {-1, 0},
            new int[] {1, 0},
            new int[] {0, -1},
            new int[] {0, 1}
    };

    public static int longestIncreasingPath(int[][] matrix) {
        if ((matrix == null) || (matrix.length == 0) || (matrix[0].length == 0)) {
            return 0;
        }

        return dp(matrix, new boolean[matrix.length][matrix[0].length]);
    }

    private static int dp(int[][] matrix, boolean[][] used) {
        // max longest increasing path starting at i,j
        int[][] dp = new int[matrix.length][matrix[0].length];

        int max = Integer.MIN_VALUE;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                if (dp[row][column] == 0) {
                    used[row][column] = true;
                    dfsWithDP(matrix, used, dp, row, column, matrix[row][column], 1);
                    used[row][column] = false;
                }
                max = Math.max(max, dp[row][column]);
            }
        }
        return max;
    }

    private static int dfsWithDP(int[][] matrix, boolean[][] used, int[][] dp, int row, int column, int lastNumber, int length) {
        int max = 0;

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newColumn = column + direction[1];

            if ((newRow < 0) || (newRow >= matrix.length) || (newColumn < 0) || (newColumn >= matrix[0].length)) {
                continue;
            }

            if (!used[newRow][newColumn]) {
                int newNumber = matrix[newRow][newColumn];
                if (newNumber <= lastNumber) {
                    continue;
                }

                int directionMax = 0;
                if (dp[newRow][newColumn] > 0) {
                    directionMax = dp[newRow][newColumn];
                }
                else {
                    used[newRow][newColumn] = true;
                    directionMax = dfsWithDP(matrix, used, dp, newRow, newColumn, newNumber, length);
                    used[newRow][newColumn] = false;
                }

                max = Math.max(max, directionMax);
            }
        }

        // for current
        max++;

        dp[row][column] = max;

        return max;
    }

    private static int backtrack(int[][] matrix, boolean[][] used) {
        int max = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                used[row][column] = true;
                max = Math.max(max, dfs(matrix, used, row, column, matrix[row][column], 1));
                used[row][column] = false;
            }
        }
        return max;
    }

    private static int dfs(int[][] matrix, boolean[][] used, int row, int column, int lastNumber, int length) {
        int max = 0;
        boolean moved = false;

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newColumn = column + direction[1];

            if ((newRow < 0) || (newRow >= matrix.length) || (newColumn < 0) || (newColumn >= matrix[0].length)) {
                continue;
            }

            if (!used[newRow][newColumn]) {
                int newNumber = matrix[newRow][newColumn];
                if (newNumber <= lastNumber) {
                    continue;
                }
                used[newRow][newColumn] = true;

                max = Math.max(max, dfs(matrix, used, newRow, newColumn, newNumber, length + 1));

                used[newRow][newColumn] = false;
                moved = true;
            }
        }

        if (!moved) {
            max = length;
        }

        return max;
    }

}
