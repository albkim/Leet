package leetcode.questions.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

 For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

 --------------------------------------------------------------------------------------------------------------

 Find the perfect square below the number. Back track to see if I can get the sum equal to # and take the min length

 TLE - need to turn this into dp
 */
public class Perfect_Squares_279 {

    public static int numSquares(int n) {
        List<Integer> perfectSquares = generatePerfectSquare(n);

        Set<Integer> lookup = new HashSet<>();
        for (int num : perfectSquares) {
            lookup.add(num);
        }

        return numSquaresDP(perfectSquares, lookup, n);
    }

    public static int numSquaresDP(List<Integer> perfectSquares, Set<Integer> lookup, int n) {
        int dp[] = new int[n + 1];

        for (int number = 1; number <= n; number++) {
            if (lookup.contains(number)) {
                dp[number] = 1;
                continue;
            }

            int min = Integer.MAX_VALUE;
            for (int index = perfectSquares.size() - 1; index >= 0; index--) {
                int remainder = number - perfectSquares.get(index);
                if (remainder >= 0) {
                    min = Math.min(min, 1 + dp[remainder]);
                }
            }
            dp[number] = min;
        }

        return dp[n];
    }

    public static int numSquaresRecursive(List<Integer> perfectSquares, Set<Integer> lookup, int n) {
        return backtrack(perfectSquares, lookup, n, 0);
    }

    private static int backtrack(List<Integer> perfectSquares, Set<Integer> lookup, int n, int count) {
        if (n == 0) {
            return count;
        }

        if (lookup.contains(n)) {
            return count + 1;
        }

        int min = Integer.MAX_VALUE;
        for (int index = perfectSquares.size() - 1; index >= 0; index--) {
            if (n - perfectSquares.get(index) >= 0) {
                min = Math.min(min, backtrack(perfectSquares, lookup, n - perfectSquares.get(index), count + 1));
            }
        }
        return min;
    }

    private static List<Integer> generatePerfectSquare(int n) {
        List<Integer> perfectSquares = new ArrayList<>();
        for (int s = 1; (s * s) <= n; s++) {
            perfectSquares.add(s * s);
        }
        return perfectSquares;
    }

}
