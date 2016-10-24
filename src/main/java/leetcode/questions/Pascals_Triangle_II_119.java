package leetcode.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 Given an index k, return the kth row of the Pascal's triangle.

 For example, given k = 3,
 Return [1,3,3,1].

 Note:
 Could you optimize your algorithm to use only O(k) extra space?


 ------------------------------------------------------------------------------------------------

 We can keep overwriting the array.

 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 [1,5,10,10,5,1]

 */
public class Pascals_Triangle_II_119 {

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();

        int[] pattern = new int[rowIndex + 1];
        for (int row = 0; row <= rowIndex; row++) {
            pattern[0] = 1;

            int index = 1;
            int backIndex = row - 1;
            while (index < Math.round(row / 2d)) {
                pattern[backIndex] = pattern[index] + pattern[index - 1];
                index++;
                backIndex--;
            }

            // if even there is additional middle piece
            if ((row > 0) && (row % 2 == 0)) {
                pattern[backIndex] = pattern[index] + pattern[index - 1];
                index++;
                backIndex--;
            }

            while (backIndex > 0) {
                pattern[backIndex] = pattern[index];
                index++;
                backIndex--;
            }

            if (row > 0) {
                pattern[row] = 1;
            }
        }

        for (int num : pattern) {
            result.add(num);
        }

        return result;
    }

}
