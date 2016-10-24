package leetcode.questions.test.dp;

import leetcode.questions.dp.Word_Break_139;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.assertTrue;

/**
 * Created by Sang on 10/7/2016.
 */
public class Word_Break_139_Test {

    @Test
    public void testSimple() {
        assertTrue(Word_Break_139.wordBreak("leetcode", new HashSet<>(Arrays.asList("leet", "code"))));
    }

}
