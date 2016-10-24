package leetcode.questions.dp;

/**
 Follow up for "Unique Paths":

 Now consider if some obstacles are added to the grids. How many unique paths would there be?

 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 For example,


 There is one obstacle in the middle of a 3x3 grid as illustrated below.
 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]


 The total number of unique paths is 2.

 Note: m and n will be at most 100.


 ----------------------------------------------------------------------------------------------------

 Seems pretty simple DP other than some custom condition of checking if neighbor has an obstacle


 */
public class Unique_Paths_II_63 {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 0;
        }

        int[][] grid = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int x = obstacleGrid[0].length - 1; x >= 0; x--) {
            for (int y = obstacleGrid.length - 1; y >= 0; y--) {
                if ((x == obstacleGrid[0].length-1) && (y == obstacleGrid.length-1) && (obstacleGrid[y][x] != 1)) {
                    grid[y][x] = 1;
                }
                else {
                    int total = 0;
                    if (obstacleGrid[y][x] != 1) {
                        if (x < obstacleGrid[0].length - 1) {
                            total += grid[y][x + 1];
                        }
                        if (y < obstacleGrid.length - 1) {
                            total += grid[y + 1][x];
                        }
                    }
                    grid[y][x] = total;
                }
            }
        }

        return grid[0][0];
    }

}
