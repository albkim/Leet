package leetcode.questions.test.binary_search;

import leetcode.questions.binary_search.Is_Subsequence_392;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 11/9/2016.
 */
public class Is_Subsequence_392_Test {

    @Test
    public void testSimple() {
        assertTrue(Is_Subsequence_392.isSubsequence("abc", "ahbgdc"));
        assertFalse(Is_Subsequence_392.isSubsequence("axc", "ahbgdc"));
    }

}
