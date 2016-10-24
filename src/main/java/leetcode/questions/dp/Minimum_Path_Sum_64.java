package leetcode.questions.dp;

/**
 Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.


 ----------------------------------------------------------------------------------------------------------

 Simple DP, taking the min of right or bottom

 */
public class Minimum_Path_Sum_64 {

    public static int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        for (int x = grid[0].length - 1; x >= 0; x--) {
            for (int y = grid.length - 1; y >= 0; y--) {
                if ((x == grid[0].length - 1) && (y == grid.length - 1)) {
                    continue;
                }
                int right = (x < grid[0].length - 1) ? grid[y][x + 1] : Integer.MAX_VALUE;
                int bottom = (y < grid.length - 1) ? grid[y + 1][x] : Integer.MAX_VALUE;
                grid[y][x] = grid[y][x] + Math.min(right, bottom);
            }
        }

        return grid[0][0];
    }

}
