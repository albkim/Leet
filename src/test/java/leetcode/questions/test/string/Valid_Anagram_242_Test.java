package leetcode.questions.test.string;

import leetcode.questions.string.Valid_Anagram_242;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/15/2016.
 */
public class Valid_Anagram_242_Test {

    @Test
    public void testSimple() {
        assertTrue(Valid_Anagram_242.isAnagram("anagram", "nagaram"));
        assertFalse(Valid_Anagram_242.isAnagram("rat", "car"));
    }

}
