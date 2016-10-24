package leetcode.questions.back_tracking;

import java.util.ArrayList;
import java.util.List;

/**
 Write a program to solve a Sudoku puzzle by filling the empty cells.

 Empty cells are indicated by the character '.'.

 You may assume that there will be only one unique solution.

 Maybe use the rules to find candidates and try each one of them with back tracking. Then recursively move onto
 next one until there is no valid option or we are done.
 */
public class Sudoku_Solver_37 {

    public static void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private static boolean solve(char[][] board, int x, int y) {
        // advance to the next empty spot
        while(board[x][y] != '.') {
            if ((y + 1) == board[0].length) {
                y = 0;
                x++;
            }
            else {
                y++;
            }

            if (x == board.length) {
                // we solved it
                return true;
            }
        }

        List<Integer> candidates = findCandidates(board, x, y);

        for (int candidate : candidates) {
            board[x][y] = String.valueOf(candidate).charAt(0);
            if (solve(board, x, y)) {
                return true;
            }
            else {
                // don't forget to reset since all candidates could fail and we need to rollback more
                board[x][y] = '.';
            }
        }

        return false;
    }

    private static List<Integer> findCandidates(char[][] board, int x, int y) {
        int[] check = new int[9];

        for (int xi = 0; xi < board.length; xi++) {
            checkIndex(board, check, xi, y);
        }

        for (int yi = 0; yi < board[0].length; yi++) {
            checkIndex(board, check, x, yi);
        }

        int xStart = x / 3 * 3;
        int yStart = y / 3 * 3;
        for (int xi = xStart; xi < xStart + 3; xi++) {
            for (int yi = yStart; yi < yStart + 3; yi++) {
                checkIndex(board, check, xi, yi);
            }
        }

        List<Integer> candidates = new ArrayList<>();
        for (int index = 0; index < check.length; index++) {
            if (check[index] == 0) {
                candidates.add(index + 1);
            }
        }
        return candidates;
    }

    private static void checkIndex(char[][] board, int[] check, int x, int y) {
        char chr = board[x][y];
        if (chr == '.') {
            return;
        }

        int index = Integer.parseInt(String.valueOf(chr)) - 1;

        check[index] = 1;
    }

}
