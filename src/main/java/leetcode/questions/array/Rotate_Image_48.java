package leetcode.questions.array;

/**
 You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 Follow up:
 Could you do this in-place?

 1  2  3
 4  5  6
 7  8  9



 -----------------------------------------------------------------------------------------



 Transpose swap(matrix[i][j], matrix[j][i])
 1  4  7
 2  5  8
 3  6  9

 flip the matrix horizontally. swap(matrix[i][j], matrix[i][matrix.length-1-j]
 7  4  1
 8  5  2
 9  6  3

 For anti clockwise, flip matrix vertically  swap(matrix[i][j], matrix[matrix.length - 1 - i][j]
 3  6  9
 2  5  8
 1  4  7

 for 180, flip horizontally and then vertically
 3  2  1        9  8  7
 6  5  4        6  5  4
 9  8  7        3  2  1
 */
public class Rotate_Image_48 {

    public static void rotate(int[][] matrix) {
        transpose(matrix);
        flipHorizontally(matrix);
    }

    private static void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                int target = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = target;
            }
        }
    }

    private static void flipHorizontally(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int target = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = matrix[i][j];
                matrix[i][j] = target;
            }
        }
    }
}
