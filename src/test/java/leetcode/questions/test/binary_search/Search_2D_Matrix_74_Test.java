package leetcode.questions.test.binary_search;

import leetcode.questions.binary_search.Search_2D_Matrix_74;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/19/2016.
 */
public class Search_2D_Matrix_74_Test {

    @Test
    public void testSimple() {
        int[][] input = new int[][] {
                new int[] {1,   3,  5,  7},
                new int[] {10, 11, 16, 20},
                new int[] {23, 30, 34, 50}
        };

        assertTrue(Search_2D_Matrix_74.searchMatrix(input, 3));
        assertTrue(Search_2D_Matrix_74.searchMatrix(input, 10));
        assertTrue(Search_2D_Matrix_74.searchMatrix(input, 50));
        assertTrue(Search_2D_Matrix_74.searchMatrix(input, 16));

        assertFalse(Search_2D_Matrix_74.searchMatrix(input, 2));
        assertFalse(Search_2D_Matrix_74.searchMatrix(input, 61));
        assertFalse(Search_2D_Matrix_74.searchMatrix(input, 0));
    }

}
