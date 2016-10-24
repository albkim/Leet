package leetcode.test.questions.binary_search;

import leetcode.questions.binary_search.Kth_Smallest_Sorted_Matrix_378;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by albertk on 8/23/16.
 */
public class Kth_Smallest_Sorted_Matrix_378_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testInValidPriorityQueue() {
        int[][] matrix = new int[][] {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };

        Kth_Smallest_Sorted_Matrix_378.kthSmallestPriorityQueue(matrix, 20);
    }

    @Test
    public void testValidPriorityQueue() {
        int[][] matrix = new int[][] {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };

        int number = Kth_Smallest_Sorted_Matrix_378.kthSmallestPriorityQueue(matrix, 8);
        assertEquals(13, number);
    }

    @Test
    public void testValidLotsOfDupesPriorityQueue() {
        int[][] matrix = new int[][] {
                {1, 5, 9, 14},
                {10, 11, 13, 15},
                {11, 12, 13, 16},
                {13, 13, 16, 17},
        };

        int number = Kth_Smallest_Sorted_Matrix_378.kthSmallestPriorityQueue(matrix, 8);
        assertEquals(13, number);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInValidBinarySearch() {
        int[][] matrix = new int[][] {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };

        Kth_Smallest_Sorted_Matrix_378.kthSmallestBinarySearch(matrix, 20);
    }

    @Test
    public void testValidBinarySearch() {
        int[][] matrix = new int[][] {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };

        int number = Kth_Smallest_Sorted_Matrix_378.kthSmallestBinarySearch(matrix, 8);
        assertEquals(13, number);
    }

    @Test
    public void testLastBinarySearch() {
        int[][] matrix = new int[][] {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };

        int number = Kth_Smallest_Sorted_Matrix_378.kthSmallestBinarySearch(matrix, 9);
        assertEquals(15, number);
    }

    @Test
    public void testValidLotsOfDupesBinarySearch() {
        int[][] matrix = new int[][] {
                {1, 5, 9, 14},
                {10, 11, 13, 15},
                {11, 12, 13, 16},
                {13, 13, 16, 17},
        };

        int number = Kth_Smallest_Sorted_Matrix_378.kthSmallestBinarySearch(matrix, 8);
        assertEquals(13, number);
    }

}
