package leetcode.questions.data_structures.stack;

import java.util.Stack;

/**
 Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 For example, given the following matrix:
 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0

 Return 6.

 ---------------------------------------------------------------------------------------------------------

 If we consider column as a histogram and transpose rows to line up, we can turn this into largest histogram problem.

 for example, this problem can be same as histogram of
 4, 1, 3, 2, 2 and 4, 1, 2, 3, 2

 Another example is
 1 1 0 1 0 1
 0 1 0 0 1 1
 1 1 1 1 0 1
 1 1 1 1 0 1

 1, 4, 0, 1, 0, 4
 0, 4, 0, 0, 1, 4
 2, 4, 2, 2, 0, 4

 Let's pre process the matrix to find heights of continuous columns and as we scan each row, we can perform largest
 histogram

 1, 1, 0, 1, 0, 1
 0, 2, 0, 0, 1, 2
 1, 3, 1, 1, 0, 3
 2, 4, 2, 2, 0, 4

 */
public class Maximal_Rectangle_85 {

    private static class Record {
        public int index;
        public int height;

        public Record(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public static int maximalRectangle(char[][] matrix) {
        if ((matrix.length == 0) || (matrix[0].length == 0)) {
            return 0;
        }

        int[][] sums = new int[matrix.length][matrix[0].length];

        for (int x = 0; x < matrix[0].length; x++) {
            int sum = 0;
            for (int y = 0; y < matrix.length; y++) {
                if (matrix[y][x] == '0') {
                    sum = 0;
                }
                else {
                    sum++;
                }
                sums[y][x] = sum;
            }
        }

        int max = 0;
        for (int y = 0; y < sums.length; y++) {
            max = Math.max(max, largestRectangleArea(sums[y]));
        }

        return max;
    }

    private static int largestRectangleArea(int[] heights) {
        Stack<Record> tracker = new Stack<>();

        int max = 0;

        for (int index = 0; index <= heights.length; index++) {
            int height = index == heights.length ? 0 : heights[index];
            if ((tracker.empty()) || (tracker.peek().height <= height)) {
                tracker.push(new Record(index, height));
            }
            else {
                int lastIndex = index;
                while(true) {
                    if ((tracker.empty()) || (tracker.peek().height <= height)) {
                        // now consider something like 2,1,2. We shouldn't insert the current height
                        // at the current index, because rect with height 1 can be formed from the last
                        // popped point
                        tracker.push(new Record(lastIndex, height));
                        break;
                    }
                    else {
                        Record record = tracker.pop();
                        lastIndex = record.index;
                        max = Math.max(max, record.height * (index - record.index));
                    }
                }
            }
        }

        return max;
    }

}
