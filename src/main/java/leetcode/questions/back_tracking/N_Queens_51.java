package leetcode.questions.back_tracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

 Given an integer n, return all distinct solutions to the n-queens puzzle.

 Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

 For example,
 There exist two distinct solutions to the 4-queens puzzle:
 [
 [".Q..",  // Solution 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // Solution 2
 "Q...",
 "...Q",
 ".Q.."]
 ]

 -------------------------------------------------------------------------------------------------------------------

 Seems like a simple back tracking problem. Since queen can move in any direction in straight line or diagonally
 once we occupy a column/row, another queen cannot use it. So at most we could try n columns/rows. Simply try the combination
 until we have a valid solution (where we can place n number of queens, and by virtue of the initial queen in different
 column/row, it will be distinct
 */
public class N_Queens_51 {

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new HashSet<>(), new ArrayList<>(), n, 0);
        return result;
    }

    private static void backtrack(List<List<String>> result, Set<Integer> currentLookup, List<Integer> current, int n, int used) {
        // base
        if (n == used) {
            List<String> board = new ArrayList<>();
            for (int row : current) {
                StringBuilder builder = new StringBuilder();
                for (int index = 0; index < n; index++) {
                    builder.append((index == row) ? 'Q' : '.');
                }
                board.add(builder.toString());
            }
            result.add(board);
        }

        // let's use the row
        // in order to be a valid board, every row has to have a queen
        // now try to find out possible columns based on already existing queens
        for (int column : possibleColumns(currentLookup, current, n)) {
            currentLookup.add(column);
            current.add(column);
            backtrack(result, currentLookup, current, n, used + 1);
            current.remove(used);
            currentLookup.remove(column);
        }
    }

    private static List<Integer> possibleColumns(Set<Integer> currentLookup, List<Integer> current, int n) {
        List<Integer> candidate = new ArrayList<>();

        for(int column = 0; column < n; column++) {
            if (!currentLookup.contains(column)) {
                // possible candidate, we just need to check diagonal towards the top
                boolean good = true;

                int left = column - 1;
                int right = column + 1;
                int row = current.size() - 1;
                while (((left >= 0) || (right <= n - 1)) && (row >= 0)) {
                    if ((current.get(row) == left) || (current.get(row) == right)) {
                        good = false;
                        break;
                    }
                    row--;
                    left--;
                    right++;
                }

                if (good) {
                    candidate.add(column);
                }
            }
        }
        return candidate;
    }

}
