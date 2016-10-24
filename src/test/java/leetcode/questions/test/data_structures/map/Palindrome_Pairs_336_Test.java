package leetcode.questions.test.data_structures.map;

import leetcode.questions.data_structures.map.Palindrome_Pairs_336;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/22/2016.
 */
public class Palindrome_Pairs_336_Test {

    @Test
    public void testSimple() {
        List<List<Integer>> result = Palindrome_Pairs_336.palindromePairs(new String[] {"bat", "tab", "cat"});

        assertEquals(2, result.size());

        assertEquals(0, result.get(0).get(0).intValue());
        assertEquals(1, result.get(0).get(1).intValue());

        assertEquals(1, result.get(1).get(0).intValue());
        assertEquals(0, result.get(1).get(1).intValue());
    }

    @Test
    public void testEdge() {
        List<List<Integer>> result = Palindrome_Pairs_336.palindromePairs(new String[] {"a", ""});

        assertEquals(2, result.size());

        assertEquals(0, result.get(0).get(0).intValue());
        assertEquals(1, result.get(0).get(1).intValue());

        assertEquals(1, result.get(1).get(0).intValue());
        assertEquals(0, result.get(1).get(1).intValue());
    }

    @Test
    public void testSimple1() {
        List<List<Integer>> result = Palindrome_Pairs_336.palindromePairs(new String[] {"abcd", "dcba", "lls", "s", "sssll"});

        assertEquals(4, result.size());

        assertEquals(0, result.get(0).get(0).intValue());
        assertEquals(1, result.get(0).get(1).intValue());

        assertEquals(1, result.get(1).get(0).intValue());
        assertEquals(0, result.get(1).get(1).intValue());

        assertEquals(3, result.get(2).get(0).intValue());
        assertEquals(2, result.get(2).get(1).intValue());

        assertEquals(2, result.get(3).get(0).intValue());
        assertEquals(4, result.get(3).get(1).intValue());
    }

    @Test
    public void testSimple2() {
        List<List<Integer>> result = Palindrome_Pairs_336.palindromePairs(new String[] {"a","abc","aba",""});

        assertEquals(4, result.size());

        assertEquals(0, result.get(0).get(0).intValue());
        assertEquals(3, result.get(0).get(1).intValue());

        assertEquals(3, result.get(1).get(0).intValue());
        assertEquals(0, result.get(1).get(1).intValue());

        assertEquals(2, result.get(2).get(0).intValue());
        assertEquals(3, result.get(2).get(1).intValue());

        assertEquals(3, result.get(3).get(0).intValue());
        assertEquals(2, result.get(3).get(1).intValue());
    }

    @Test
    public void testSimple3() {
        List<List<Integer>> result = Palindrome_Pairs_336.palindromePairs(new String[]{"abaabaa", "aaba"});

        assertEquals(1, result.size());

        assertEquals(1, result.get(0).get(0).intValue());
        assertEquals(0, result.get(0).get(1).intValue());
    }

}
