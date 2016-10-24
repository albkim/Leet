package leetcode.questions.test.dp;

import leetcode.questions.dp.Distinct_Subsequences_115;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/2/2016.
 */
public class Distinct_Subsequences_115_Test {

    @Test
    public void testSimple() {
        assertEquals(1, Distinct_Subsequences_115.numDistinct("ABCDE", "ACE"));
        assertEquals(0, Distinct_Subsequences_115.numDistinct("ABCDE", "AEC"));
        assertEquals(3, Distinct_Subsequences_115.numDistinct("rabbbit", "rabbit"));
        assertEquals(3, Distinct_Subsequences_115.numDistinct("ccc", "c"));
        assertEquals(1, Distinct_Subsequences_115.numDistinct("eee", "eee"));
    }

}
