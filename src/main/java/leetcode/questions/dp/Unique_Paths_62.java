package leetcode.questions.dp;

/**
 A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?




 Above is a 3 x 7 grid. How many possible unique paths are there?

 Note: m and n will be at most 100.



 -------------------------------------------------------------------------------------------------------------------

 Seems like a simple DP where I start from the bottom right and calculate all possible path as I move towards the origin


 */
public class Unique_Paths_62 {

    public static int uniquePaths(int m, int n) {
        // since robot can only move right and down, we can start from bottom right and move up and then left to build
        // up the dp

        int[][] grid = new int[m][n];
        for (int x = n - 1; x >= 0; x--) {
            for (int y = m - 1; y >= 0; y--) {
                if ((x == n-1) && (y == m-1)) {
                    grid[y][x] = 1;
                }
                else {
                    int total = 0;
                    if (x < n - 1) {
                        total += grid[y][x + 1];
                    }
                    if (y < m - 1) {
                        total += grid[y + 1][x];
                    }
                    grid[y][x] = total;
                }
            }
        }

        return grid[0][0];
    }

}
