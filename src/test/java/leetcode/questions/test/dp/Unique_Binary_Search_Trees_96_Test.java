package leetcode.questions.test.dp;

import leetcode.questions.dp.Unique_Binary_Search_Trees_96;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/29/2016.
 */
public class Unique_Binary_Search_Trees_96_Test {

    @Test
    public void testSimple() {
        assertEquals(0, Unique_Binary_Search_Trees_96.numTrees(0));
        assertEquals(1, Unique_Binary_Search_Trees_96.numTrees(1));
        assertEquals(2, Unique_Binary_Search_Trees_96.numTrees(2));
        assertEquals(5, Unique_Binary_Search_Trees_96.numTrees(3));
    }

}
