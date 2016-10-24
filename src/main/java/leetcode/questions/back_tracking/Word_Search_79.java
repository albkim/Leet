package leetcode.questions.back_tracking;

/**
 Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally
 or vertically neighboring. The same letter cell may not be used more than once.

 For example,
 Given board =
 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]

 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.


 ---------------------------------------------------------------------------------------------------------------

 Find the first char, and the bfs with backtracking to see if word can be made?

 */
public class Word_Search_79 {

    public static boolean exist(char[][] board, String word) {
        if ((word == null) || (word.length() == 0)) {
            return false;
        }
        if ((board.length == 0) || (board[0].length == 0)) {
            return false;
        }

        return search(board, word);
    }

    private static boolean search(char[][] board, String word) {
        char firstChar = word.charAt(0);

        boolean[][] used = new boolean[board.length][board[0].length];
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (board[y][x] == firstChar) {
                    used[y][x] = true;
                    if (backtrack(board, used, y, x, word, 1)) {
                        return true;
                    }
                    used[y][x] = false;
                }
            }
        }

        return false;
    }

    private static boolean backtrack(char[][] board, boolean[][] used, int y, int x, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        int[][] directions = new int[][] {
                new int[] {-1, 0},
                new int[] {1, 0},
                new int[] {0, -1},
                new int[] {0, 1}
        };

        for (int[] direction : directions) {
            char chr = word.charAt(index);

            int ySearch = y + direction[0];
            int xSearch = x + direction[1];

            if ((xSearch >= 0) && (ySearch >= 0) && (xSearch < board[0].length) && (ySearch < board.length) &&
                    (!used[ySearch][xSearch]) && (board[ySearch][xSearch] == chr)) {
                used[ySearch][xSearch] = true;
                if (backtrack(board, used, ySearch, xSearch, word, index + 1)) {
                    return true;
                }
                used[ySearch][xSearch] = false;
            }
        }

        return false;
    }

}
