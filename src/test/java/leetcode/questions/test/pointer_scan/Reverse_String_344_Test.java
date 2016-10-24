package leetcode.test.questions.pointer_scan;

import leetcode.questions.pointer_scan.Reverse_String_344;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by albertk on 10/6/16.
 */
public class Reverse_String_344_Test {

    @Test
    public void testSimple() {
        assertEquals("olleh", Reverse_String_344.reverseString("hello"));
    }

}
