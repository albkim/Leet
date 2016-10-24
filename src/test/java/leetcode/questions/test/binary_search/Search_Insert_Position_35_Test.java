package leetcode.questions.test.binary_search;

import leetcode.questions.binary_search.Search_Insert_Position_35;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/10/2016.
 */
public class Search_Insert_Position_35_Test {

    @Test
    public void testInsertSmall() {
        assertEquals(0, Search_Insert_Position_35.searchInsert(new int[] {1,3,5,6}, 0));
    }

    @Test
    public void testInsertLarge() {
        assertEquals(4, Search_Insert_Position_35.searchInsert(new int[] {1,3,5,6}, 7));
    }

    @Test
    public void testInsertMiddle() {
        assertEquals(1, Search_Insert_Position_35.searchInsert(new int[] {1,3,5,6}, 2));
    }

    @Test
    public void testFound() {
        assertEquals(2, Search_Insert_Position_35.searchInsert(new int[] {1,3,5,6}, 5));
    }

}
