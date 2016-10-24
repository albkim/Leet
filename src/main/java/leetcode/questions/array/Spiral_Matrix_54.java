package leetcode.questions.array;

import java.util.ArrayList;
import java.util.List;

/**
 Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

 For example,
 Given the following matrix:
 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]

 You should return [1,2,3,6,9,8,7,4,5].


 1 2 3
 4 5 6
 7 8 9
 1 2 3

 -----------------------------------------------------------------------------------------


 Simply use a for loop to determine starting point of a layer, it can only go up to the mid point of smallest dimension

 then scan right
 scan bottom (from top + 1 to bottom - 1)
 scan left
 scan top (from bottom - 1 to top + 1)
 */
public class Spiral_Matrix_54 {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }

        // 1 & 2 = 1, 3 & 4 = 2
        int mid = (int)Math.ceil(Math.min(matrix.length, matrix[0].length) / 2d);
        for (int iteration = 0; iteration < mid; iteration++) {
            // right
            int xMax = matrix[0].length - 1 - iteration;
            int yMax = matrix.length - 1 - iteration;
            for (int x = iteration; x <= xMax; x++) {
                result.add(matrix[iteration][x]);
            }

            // bottom
            for (int y = iteration + 1; y < yMax; y++) {
                result.add(matrix[y][xMax]);
            }

            if (iteration < yMax) {
                // left
                for (int x = xMax; x >= iteration; x--) {
                    result.add(matrix[yMax][x]);
                }
            }

            if (iteration < xMax) {
                // top
                for (int y = yMax - 1; y > iteration; y--) {
                    result.add(matrix[y][iteration]);
                }
            }
        }
        return result;
    }

}
