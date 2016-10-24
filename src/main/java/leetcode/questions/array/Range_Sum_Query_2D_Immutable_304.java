package leetcode.questions.array;

/**
 Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left
 corner (row1, col1) and lower right corner (row2, col2).

 Range Sum Query 2D
 The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3),
 which contains sum = 8.

 Example:

 Given matrix = [
 [3, 0, 1, 4, 2],
 [5, 6, 3, 2, 1],
 [1, 2, 0, 1, 5],
 [4, 1, 0, 1, 7],
 [1, 0, 3, 0, 5]
 ]

 sumRegion(2, 1, 4, 3) -> 8
 sumRegion(1, 1, 2, 2) -> 11
 sumRegion(1, 2, 2, 4) -> 12

 Note:

 1.You may assume that the matrix does not change.
 2.There are many calls to sumRegion function.
 3.You may assume that row1 ? row2 and col1 ? col2.

 ------------------------------------------------------------------------------------------------

 Running sum from 0 -> (x,y) and then use the 4 rectangle trick

 Seems like i can optimize using the sum of x+y trick D = (0 -> D) - (0 -> B) - (0 -> C) + (0 -> A)
 still left -> right , but i don't need to sum up each row, making this n2 with continuous sum 1D array trick
 ---------
 | A | B |
 ---------
 | C | D |
 ---------

 */
public class Range_Sum_Query_2D_Immutable_304 {

    private int[][] cache;

    public Range_Sum_Query_2D_Immutable_304(int[][] matrix) {
        if ((matrix == null) || (matrix.length == 0) || (matrix[0].length == 0)) {
            return;
        }

        this.cache = new int[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            int rowSum = 0;
            for (int column = 0; column < matrix[0].length; column++) {
                int previous = (row > 0) ? this.cache[row - 1][column] : 0;
                this.cache[row][column] = rowSum + previous + matrix[row][column];
                rowSum += matrix[row][column];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (this.cache == null) {
            return 0;
        }

        int sum = this.cache[row2][col2];

        if (row1 > 0) {
            sum -= this.cache[row1 - 1][col2];
        }
        if (col1 > 0) {
            sum -= this.cache[row2][col1 - 1];
        }
        if ((row1 > 0) && (col1 > 0)) {
            sum += this.cache[row1 - 1][col1 - 1];
        }

        return sum;
    }

}
