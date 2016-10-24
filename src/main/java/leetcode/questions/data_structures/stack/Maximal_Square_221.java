package leetcode.questions.data_structures.stack;

import java.util.Stack;

/**
 Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

 For example, given the following matrix:
 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0

 Return 4.

 -------------------------------------------------------------------------------------------------------

 Seems like it's similar to maximal rectangle. Scan line by line and create a histogram...then as we
 calculate the rectangle area. make sure it's a square

 */
public class Maximal_Square_221 {

    private static class Record {
        public int column;
        public int height;

        public Record(int column, int height) {
            this.column = column;
            this.height = height;
        }
    }

    public static int maximalSquare(char[][] matrix) {
        if ((matrix == null) || (matrix.length == 0) || (matrix[0].length == 0)) {
            return 0;
        }

        int[][] dp = new int[matrix.length][matrix[0].length + 1];

        int max = 0;
        for (int row = 0; row < matrix.length; row++) {
            Stack<Record> heights = new Stack<>();
            for (int column = 0; column <= matrix[0].length; column++) {
                int previous = (row > 0) ? dp[row - 1][column] : 0;
                int height = (column == matrix[0].length) ? 0 : (matrix[row][column] == '1' ? previous + 1 : 0);

                if ((heights.size() == 0) || (height >= heights.peek().height)) {
                    // if current histogram is greater than the existing, push into stack
                    heights.push(new Record(column, height));
                }
                else {
                    // pop off till we hit a equal or smaller, calculating the area
                    // make sure it's only a square
                    int minColumn = Integer.MAX_VALUE;
                    while ((!heights.empty()) && (heights.peek().height > height)) {
                        Record record = heights.pop();
                        int width = column - record.column;
                        int minDimension = Math.min(width, record.height);

                        minColumn = Math.min(minColumn, record.column);
                        max = Math.max(max, minDimension * minDimension);
                    }

                    // push this
                    heights.push(new Record(minColumn, height));
                }

                dp[row][column] = height;
            }
        }
        return max;
    }

}
