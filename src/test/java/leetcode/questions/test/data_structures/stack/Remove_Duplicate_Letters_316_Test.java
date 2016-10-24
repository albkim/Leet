package leetcode.questions.test.data_structures.stack;

import leetcode.questions.data_structures.stack.Remove_Duplicate_Letters_316;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/20/2016.
 */
public class Remove_Duplicate_Letters_316_Test {

    @Test
    public void testSimple() {
        assertEquals("abc", Remove_Duplicate_Letters_316.removeDuplicateLetters("bcabc"));
        assertEquals("acdb", Remove_Duplicate_Letters_316.removeDuplicateLetters("cbacdcbc"));
    }

    @Test
    public void testSimple1() {
        assertEquals("bac", Remove_Duplicate_Letters_316.removeDuplicateLetters("bbbacacca"));
    }

}
