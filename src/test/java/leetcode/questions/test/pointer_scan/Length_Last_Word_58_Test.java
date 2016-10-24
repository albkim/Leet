package leetcode.questions.test.pointer_scan;

import leetcode.questions.pointer_scan.Length_Last_Word_58;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/17/2016.
 */
public class Length_Last_Word_58_Test {

    @Test
    public void testEmpty() {
        assertEquals(0, Length_Last_Word_58.lengthOfLastWord(""));
    }

    @Test
    public void testEdge() {
        assertEquals(1, Length_Last_Word_58.lengthOfLastWord("a "));
    }

    @Test
    public void testSingle() {
        assertEquals(5, Length_Last_Word_58.lengthOfLastWord("world"));
    }

    @Test
    public void testSpace() {
        assertEquals(5, Length_Last_Word_58.lengthOfLastWord("Hello World"));
    }

}
