package leetcode.questions.test.pointer_scan;

import leetcode.questions.pointer_scan.Valid_Palindrome_125;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/4/2016.
 */
public class Valid_Palindrome_125_Test {

    @Test
    public void testEdge() {
        assertTrue(Valid_Palindrome_125.isPalindrome("        "));
    }

    @Test
    public void testEdge1() {
        assertFalse(Valid_Palindrome_125.isPalindrome("0P"));
    }

    @Test
    public void testSimple() {
        assertFalse(Valid_Palindrome_125.isPalindrome("race a car"));
        assertTrue(Valid_Palindrome_125.isPalindrome("A man, a plan, a canal: Panama"));
    }

}
