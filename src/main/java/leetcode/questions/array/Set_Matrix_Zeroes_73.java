package leetcode.questions.array;

/**
 Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

 Follow up:
 Did you use extra space?
 A straight forward solution using O(mn) space is probably a bad idea.
 A simple improvement uses O(m + n) space, but still not the best solution.
 Could you devise a constant space solution?


 ------------------------------------------------------------------------------------------------------------

 Constant space usually means we need to use the input array. What if I use a row and a column to track which row/column has 0
 The trick here is to then track if there were 0's in these rows itself. And do extra marking.


 */
public class Set_Matrix_Zeroes_73 {

    public static void setZeroes(int[][] matrix) {
        boolean zeroInFirstRow = false;
        boolean zeroInFirstColumn = false;

        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                if (matrix[y][x] == 0) {
                    if (y == 0) {
                        zeroInFirstRow = true;
                    }
                    if (x == 0) {
                        zeroInFirstColumn = true;
                    }

                    matrix[0][x] = 0;
                    matrix[y][0] = 0;
                }
            }
        }

        for (int y = 1; y < matrix.length; y++) {
            if (matrix[y][0] == 0) {
                for (int x = 0; x < matrix[0].length; x++) {
                    matrix[y][x] = 0;
                }
            }
        }
        for (int x = 1; x < matrix[0].length; x++) {
            if (matrix[0][x] == 0) {
                for (int y = 0; y < matrix.length; y++) {
                    matrix[y][x] = 0;
                }
            }
        }

        if (zeroInFirstRow) {
            for (int x = 0; x < matrix[0].length; x++) {
                matrix[0][x] = 0;
            }
        }

        if (zeroInFirstColumn) {
            for (int y = 0; y < matrix.length; y++) {
                matrix[y][0] = 0;
            }
        }
    }

}
