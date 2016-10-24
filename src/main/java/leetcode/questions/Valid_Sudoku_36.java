package leetcode.questions;

/**
 Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
    9 x 9 square
        a row should only contain 1-9 once
        a column should only contain 1-9 once
        a 3 x 3 sub square should only contain 1-9 once

 The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

 A partially filled sudoku which is valid.

 Note:
 A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated

 linearly scan 3 times with an array...still linear
 */
public class Valid_Sudoku_36 {

    public static boolean isValidSudoku(char[][] board) {
        for (int x = 0; x < board.length; x++) {
            int[] check = new int[board[0].length];
            for (int y = 0; y < check.length; y++) {
                if (!isValid(board, check, x, y)) {
                    return false;
                }
            }
        }

        for (int y = 0; y < board[0].length; y++) {
            int[] check = new int[board.length];
            for (int x = 0; x < check.length; x++) {
                if (!isValid(board, check, x, y)) {
                    return false;
                }
            }
        }

        for (int x = 0; x < board.length; x += 3) {
            for (int y = 0; y < board[0].length; y += 3) {
                int[] check = new int[board.length];
                for (int xi = x; xi < x + 3; xi++) {
                    for (int yi = y; yi < y + 3; yi++) {
                        if (!isValid(board, check, xi, yi)) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    private static boolean isValid(char[][] board, int[] check, int x, int y) {
        char chr = board[x][y];
        if (chr == '.') {
            return true;
        }

        int number = Integer.parseInt(String.valueOf(chr)) - 1;
        if (check[number] == 1) {
            return false;
        }

        check[number] = 1;
        return true;
    }

}
