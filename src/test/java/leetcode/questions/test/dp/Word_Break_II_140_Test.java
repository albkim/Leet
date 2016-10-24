package leetcode.questions.test.dp;

import leetcode.questions.dp.Word_Break_II_140;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/7/2016.
 */
public class Word_Break_II_140_Test {

    @Test
    public void testSimple() {
        List<String> result = Word_Break_II_140.wordBreak("catsanddog", new HashSet<>(Arrays.asList("cat", "cats", "and", "sand", "dog")));

        assertEquals(2, result.size());

        assertEquals("cat sand dog", result.get(0));
        assertEquals("cats and dog", result.get(1));
    }

    @Test
    public void testSlow() {
        List<String> result = Word_Break_II_140.wordBreak(
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                new HashSet<>(Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));

        assertEquals(0, result.size());
    }

}
