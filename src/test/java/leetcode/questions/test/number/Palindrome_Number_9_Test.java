package leetcode.questions.test.number;

import leetcode.questions.number.Palindrome_Number_9;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/1/2016.
 */
public class Palindrome_Number_9_Test {

    @Test
    public void testNegative() {
        assertFalse(Palindrome_Number_9.isPalindrome(-1));
    }

    @Test
    public void testOneDigit() {
        assertTrue(Palindrome_Number_9.isPalindrome(5));
    }

    @Test
    public void testPattern1() {
        assertTrue(Palindrome_Number_9.isPalindrome(454));
    }

    @Test
    public void testPattern2() {
        assertTrue(Palindrome_Number_9.isPalindrome(44));
    }

    @Test
    public void testBig() {
        assertTrue(Palindrome_Number_9.isPalindrome(11111111));
    }

    @Test
    public void testFalse() {
        assertFalse(Palindrome_Number_9.isPalindrome(12345));
    }

}
