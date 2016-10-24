package leetcode.questions.test.pointer_scan;

import leetcode.questions.pointer_scan.Reverse_Words_String_151;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/8/2016.
 */
public class Reverse_Words_String_151_Test {

    @Test
    public void testEdge() {
        assertEquals("a", Reverse_Words_String_151.reverseWords("a"));
        assertEquals("abc", Reverse_Words_String_151.reverseWords("abc"));
    }

    @Test
    public void testEdge2() {
        assertEquals("b a", Reverse_Words_String_151.reverseWords("   a   b "));
    }

    @Test
    public void testSimple() {
        assertEquals("blue is sky the", Reverse_Words_String_151.reverseWords("the sky is blue"));
    }

}
