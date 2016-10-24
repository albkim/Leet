package leetcode.questions.test.data_structures.map;

import leetcode.questions.data_structures.map.Word_Pattern_290;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/17/2016.
 */
public class Word_Pattern_290_Test {

    @Test
    public void testSimple() {
        assertTrue(Word_Pattern_290.wordPattern("abba", "dog cat cat dog"));
        assertFalse(Word_Pattern_290.wordPattern("abba", "dog cat cat fish"));
        assertFalse(Word_Pattern_290.wordPattern("aaaa", "dog cat cat dog"));
        assertFalse(Word_Pattern_290.wordPattern("abba", "dog dog dog dog"));
    }

    @Test
    public void testEdge() {
        assertFalse(Word_Pattern_290.wordPattern("jquery", "jquery"));
    }

}
