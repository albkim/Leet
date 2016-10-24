package leetcode.questions.pointer_scan;

import java.util.TreeSet;

/**
 Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that its sum is no larger than k.
 Example: 
 Given matrix = [
 [1,  0, 1],
 [0, -2, 3]
 ]
 k = 2

 The answer is 2. Because the sum of rectangle [[0, 1], [-2, 3]] is 2 and 2 is the max number no larger than k (k = 2).
 Note: 
 1.	The rectangle inside the matrix must have an area > 0.
 2.	What if the number of rows is much larger than the number of columns?


 ----------------------------------------------------------------------------------------



 Naive solution would give n^4...since for every possible pair, sum has to be calculated

 Seems like i can optimize using the sum of x+y trick D = (0 -> D) - (0 -> B) - (0 -> C) + (0 -> A)
    still left -> right , but i don't need to sum up each row, making this n2 with continuous sum 1D array trick
 ---------
 | A | B |
 ---------
 | C | D |
 ---------

 Then use the treeset to find the closest next sum to give the sub range sum closest to k

 complexity of (n + (n-1) + (n-2)...) n log n....building cache is n^2

 */
public class Max_Sum_Rectangle_No_Larger_Than_K_363 {

    public static int maxSumSubmatrix(int[][] matrix, int k) {
        if ((matrix.length == 0) || (matrix[0].length == 0)) {
            return 0;
        }

        int[][] cache = buildCacheForMatrix(matrix);
        
        // O(n + (n-1) + (n-2)...) here
        int max = Integer.MIN_VALUE;
        for (int left = 0; left < matrix[0].length; left++) {
            for (int right = left; right < matrix[0].length; right++) {
                int sum = maxSumSubmatrixFromCache(cache, k, left, right);
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    private static int[][] buildCacheForMatrix(int[][] matrix) {
        int[][] cache = new int[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                int sum = matrix[row][column];

                if (column > 0) {
                    sum += cache[row][column - 1];
                }
                if (row > 0) {
                    sum += cache[row - 1][column];
                    if (column > 0) {
                        sum -= cache[row - 1][column - 1];
                    }
                }

                cache[row][column] = sum;
            }
        }

        return cache;
    }

    private static int maxSumSubmatrixFromCache(int[][] cache, int k, int left, int right) {
        // the 1D continuous sum trick is as I add numbers, keep the max, once the continuous sum dips below 0,
        // then reset the continuous sum.
        // with k...we probably want to include negative affect
        int max = Integer.MIN_VALUE;
        TreeSet<Integer> lookup = new TreeSet<>();
        for (int bottom = 0; bottom < cache.length; bottom++) {
            int sum = cache[bottom][right];
            if ((right - left) > 0) {
                sum -= cache[bottom][left];
            }

            // consider the current sum, it could be that total is <= k and we shouldn't try to find a sub array
            if (sum <= k) {
                max = Math.max(max, sum);
            }

            // ceiling smallest number which is greater than or equal to input
            // O(log n)
            Integer smallestPreviousSum = lookup.ceiling(sum - k);
            lookup.add(sum);

            if (smallestPreviousSum == null) {
                continue;
            }
            int diff = sum - smallestPreviousSum;
            max = Math.max(max, diff);
        }

        return max;
    }
}
