package leetcode.questions.test.pointer_scan;

import leetcode.questions.pointer_scan.Shortest_Palindrome_214;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/13/2016.
 */
public class Shortest_Palindrome_214_Test {

    @Test
    public void testSimple() {
        assertEquals("baababbabaab", Shortest_Palindrome_214.shortestPalindrome("abbabaab"));
        assertEquals("aaacecaaa", Shortest_Palindrome_214.shortestPalindrome("aacecaaa"));
        assertEquals("dcbabcd", Shortest_Palindrome_214.shortestPalindrome("abcd"));
    }

}
