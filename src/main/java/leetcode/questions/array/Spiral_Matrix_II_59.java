package leetcode.questions.array;

/**
 Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

 For example,
 Given n = 3,
 You should return the following matrix: [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]



 --------------------------------------------------------------------------------------------------

 Seems pretty simple, for each iteration, just need to generate coordinates for n x n matrix


 */
public class Spiral_Matrix_II_59 {

    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int number = 1;
        int iteration = n / 2 + (n % 2);

        for(int count = 0; count < iteration; count++) {
            int left = count;
            int right = n - count - 1;
            int top = count;
            int bottom = n - count - 1;

            // top
            for (int index = left; index <= right; index++) {
                result[top][index] = number;
                number++;
            }

            // now right...
            for (int index = top + 1; index <= bottom - 1; index++) {
                result[index][right] = number;
                number++;
            }

            // now bottom, only if different from top
            if (bottom != top) {
                for (int index = right; index >= left; index--) {
                    result[bottom][index] = number;
                    number++;
                }
            }

            // now left, only if different from right
            if (left != right) {
                for (int index = bottom - 1; index >= top + 1; index--) {
                    result[index][left] = number;
                    number++;
                }
            }
        }

        return result;
    }

}
