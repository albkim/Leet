package leetcode.questions.test.binary_search;

import leetcode.questions.binary_search.Search_2D_Matrix_II_240;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/15/2016.
 */
public class Search_2D_Matrix_II_240_Test {

    @Test
    public void testEdge() {
        assertTrue(Search_2D_Matrix_II_240.searchMatrix(new int[][] {new int[]{-5}}, -5));
        assertFalse(Search_2D_Matrix_II_240.searchMatrix(new int[][] {new int[]{-5}}, -10));
    }

    @Test
    public void testEdge1() {
        assertTrue(Search_2D_Matrix_II_240.searchMatrix(new int[][]{new int[]{1, 4}, new int[]{2, 5}}, 5));
    }

    @Test
    public void testSimple() {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        assertTrue(Search_2D_Matrix_II_240.searchMatrix(matrix, 5));
        assertFalse(Search_2D_Matrix_II_240.searchMatrix(matrix, 70));
    }

    @Test
    public void testSimple2() {
        int[][] matrix = new int[][] {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };

        assertTrue(Search_2D_Matrix_II_240.searchMatrix(matrix, 5));
    }

}
