package leetcode.test.questions.pointer_scan;

import leetcode.questions.pointer_scan.Reverse_Vowels_String_345;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by albertk on 10/5/16.
 */
public class Reverse_Vowels_String_345_Test {

    @Test
    public void testSimple() {
        assertEquals("holle", Reverse_Vowels_String_345.reverseVowels("hello"));
        assertEquals("leotcede", Reverse_Vowels_String_345.reverseVowels("leetcode"));
    }

}
