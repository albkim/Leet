package leetcode.questions.array;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 For example,

 X X X X
 X O O X
 X X O X
 X O X X



 After running your function, the board should be:
 X X X X
 X X X X
 X X X X
 X O X X

---------------------------------------------------------------------------------------------------------

 Similar to finding island, we can traverse all O's and see if we hit one of the sides. If this happens I cannot
 flip this region and mark it as travelled, otherwise, flip it

 above ran into stack overflow...another idea is to first mark all valid region as visited (start from each edge)
 and flip the rest

 lol dfs keep getting stack overflow, change to bfs

 */
public class Surrounded_Regions_130 {

    public static void solve(char[][] board) {
        if ((board.length == 0) || (board[0].length == 0)) {
            return;
        }

        Queue<int[]> current = new ArrayDeque<>();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == 'O') {
                visited[row][0] = true;
                current.add(new int[]{row, 0});
            }
            if (board[row][board[0].length - 1] == 'O') {
                visited[row][board[0].length - 1] = true;
                current.add(new int[]{row, board[0].length - 1});
            }
        }

        for (int column = 0; column < board[0].length; column++) {
            if (board[0][column] == 'O') {
                visited[0][column] = true;
                current.add(new int[]{0, column});
            }
            if (board[board.length - 1][column] == 'O') {
                visited[board.length - 1][column] = true;
                current.add(new int[]{board.length - 1, column});
            }
        }

        bfs(board, visited, current);

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if ((!visited[row][column]) && (board[row][column] == 'O')) {
                    board[row][column] = 'X';
                }
            }
        }
    }

    private static void bfs(char[][] board, boolean[][] visited, Queue<int[]> current) {
        int[][] coordinates = new int[][] {
                new int[] {0, -1},
                new int[] {0, 1},
                new int[] {-1, 0},
                new int[] {1, 0}
        };

        Queue<int[]> next = new ArrayDeque<>();

        while (!current.isEmpty()) {
            int[] start = current.poll();
            visited[start[0]][start[1]] = true;

            for (int[] coordinate : coordinates) {
                // dfs
                if ((start[0] + coordinate[0] >= 0) && (start[0] + coordinate[0] < board.length)
                        && (start[1] + coordinate[1] >= 0) && (start[1] + coordinate[1] < board[0].length)
                        && (!visited[start[0] + coordinate[0]][start[1] + coordinate[1]])
                        && (board[start[0] + coordinate[0]][start[1] + coordinate[1]] == 'O')) {
                    next.add(new int[] {start[0] + coordinate[0], start[1] + coordinate[1]});
                }
            }

            if (current.isEmpty()) {
                current = next;
                next = new ArrayDeque<>();
            }
        }
    }

}
