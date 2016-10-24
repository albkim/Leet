package leetcode.questions.data_structures.graph;

/**
 Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by
 water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four
 edges of the grid are all surrounded by water.

 Example 1:
 11110
 11010
 11000
 00000

 Answer: 1

 Example 2:
 11000
 11000
 00100
 00011

 Answer: 3

 ------------------------------------------------------------------------------------------------------

 Once we hit 1, dfs all neighboring 1's, mark all of them as visited, and add one to count. Then we can do this until we reach
 the end and return count.
 */
public class Number_Of_Islands_200 {

    public static int numIslands(char[][] grid) {
        if ((grid == null) || (grid.length == 0) || (grid[0].length == 0)) {
            return 0;
        }

        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if ((!visited[row][column]) && (grid[row][column] == '1')) {
                    dfs(visited, grid, row, column);
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfs(boolean[][] visited, char[][] grid, int row, int column) {
        if ((row < 0) || (row >= grid.length) || (column < 0) || (column >= grid[0].length)
                || (visited[row][column])) {
            // out of bound or already visited place
            return;
        }

        visited[row][column] = true;

        if (grid[row][column] == '1') {
            dfs(visited, grid, row - 1, column);
            dfs(visited, grid, row + 1, column);
            dfs(visited, grid, row, column - 1);
            dfs(visited, grid, row, column + 1);
        }
    }

}
