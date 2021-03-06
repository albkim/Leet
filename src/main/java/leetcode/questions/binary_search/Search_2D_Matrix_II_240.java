package leetcode.questions.binary_search;

/**
 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:


 �Integers in each row are sorted in ascending from left to right.
 �Integers in each column are sorted in ascending from top to bottom.


 For example,

 Consider the following matrix:
 [
 [1,   4,  7, 8, 15],
 [2,   5,  8, 12, 19],
 [3,   6,  9, 16, 22],
 [10, 13, 14, 17, 24],
 [18, 21, 23, 26, 30]
 ]


 Given target = 5, return true.

 Given target = 20, return false.

 ---------------------------------------------------------------------------------------------

 Seems like 2D binary search. Once we pick a number, we know all the numbers top left are small (pick 9 and we know top left
 rectangle is smaller (numbers above in the column have to be smaller, making all rows below smaller)

 Looks like there is even better approach with O(m + n) complexity
 We need to start either at top right corner or bottom left corner. If # is greater, it cannot exists in the entire row (since largest
 is at right end), so can move down a row. If # is smaller, then it cannot exists in the column since smallest is in the top, so we
 move left.
 */
public class Search_2D_Matrix_II_240 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        return search(matrix, target);
    }

    private static boolean search(int[][] matrix, int target) {
        int y = 0;
        int x = matrix[0].length - 1;

        while ((x >= 0) && (y < matrix.length)) {
            int number = matrix[y][x];
            if (number == target) {
                return true;
            }
            else if (number < target) {
                y++;
            }
            else if (number > target) {
                x--;
            }
        }

        return false;
    }

    private static boolean binarySearch2D(int[][] matrix, int target, int top, int bottom, int left, int right) {
        int verticalMid = top + ((bottom - top) >> 1);
        int horizontalMid = left + ((right - left) >> 1);

        int mid = matrix[verticalMid][horizontalMid];

        if (mid == target) {
            return true;
        }

        if ((top == bottom) && (left == right)) {
            return false;
        }

        // top left - we only need to look at this if the number is smaller
        if (target < mid) {
            if (binarySearch2D(matrix, target, top, verticalMid, left, horizontalMid)) {
                return true;
            }
        }

        // bottom right - only required if target is bigger than this value, then we only need to search this quarter
        if ((verticalMid < bottom) && (horizontalMid < right)) {
            int bottomRight = matrix[verticalMid + 1][horizontalMid + 1];
            if (target >= bottomRight) {
                if (binarySearch2D(matrix, target, verticalMid + 1, bottom, horizontalMid + 1, right)) {
                    return true;
                }
            }
        }

        // if we are here...no easy one...
        if (verticalMid < bottom) {
            if (binarySearch2D(matrix, target, verticalMid + 1, bottom, left, horizontalMid)) {
                return true;
            }
        }
        if (horizontalMid < right) {
            if (binarySearch2D(matrix, target, top, verticalMid, horizontalMid + 1, right)) {
                return true;
            }
        }

        return false;
    }

}
