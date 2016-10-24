package leetcode.questions.test.back_tracking;

import leetcode.questions.back_tracking.Palindrome_Partitioning_131;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/5/2016.
 */
public class Palindrome_Partitioning_131_Test {

    @Test
    public void testSimple() {
        List<List<String>> result = Palindrome_Partitioning_131.partition("aab");

        assertEquals(2, result.size());

        assertEquals(3, result.get(0).size());
        assertEquals("a", result.get(0).get(0));
        assertEquals("a", result.get(0).get(1));
        assertEquals("b", result.get(0).get(2));

        assertEquals(2, result.get(1).size());
        assertEquals("aa", result.get(1).get(0));
        assertEquals("b", result.get(1).get(1));
    }

}
