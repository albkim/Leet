package leetcode.questions.back_tracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 Follow up for N-Queens problem.

 Now, instead outputting board configurations, return the total number of distinct solutions.

 */
public class N_Queens_II_52 {

    public static int totalNQueens(int n) {
        return backtrack(new HashSet<>(), new ArrayList<>(), n, 0);
    }

    private static int backtrack(Set<Integer> currentLookup, List<Integer> current, int n, int used) {
        // base
        if (n == used) {
            return 1;
        }

        // let's use the row
        // in order to be a valid board, every row has to have a queen
        // now try to find out possible columns based on already existing queens
        int total = 0;
        for (int column : possibleColumns(currentLookup, current, n)) {
            currentLookup.add(column);
            current.add(column);
            total += backtrack(currentLookup, current, n, used + 1);
            current.remove(used);
            currentLookup.remove(column);
        }
        return total;
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
