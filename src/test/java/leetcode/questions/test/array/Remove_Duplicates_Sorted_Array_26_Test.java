package leetcode.questions.test.array;

import leetcode.questions.array.Remove_Duplicates_Sorted_Array_26;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/5/2016.
 */
public class Remove_Duplicates_Sorted_Array_26_Test {

    @Test
    public void testSimple() {
        assertEquals(2, Remove_Duplicates_Sorted_Array_26.removeDuplicates(new int[] {1, 1, 2}));
    }

}
