package leetcode.questions.test.data_structures.trie;

import leetcode.questions.data_structures.trie.Add_Search_Word_211;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/12/2016.
 */
public class Add_Search_Word_211_Test {

    @Test
    public void testSimple() {
        Add_Search_Word_211 search = new Add_Search_Word_211();

        search.addWord("bad");
        search.addWord("dad");
        search.addWord("mad");

        assertFalse(search.search("pad"));
        assertTrue(search.search("bad"));
        assertTrue(search.search(".ad"));
        assertTrue(search.search("b.."));
    }

    @Test
    public void testSimple1() {
        Add_Search_Word_211 search = new Add_Search_Word_211();

        assertFalse(search.search("a"));
    }

    @Test
    public void testSimple2() {
        Add_Search_Word_211 search = new Add_Search_Word_211();

        search.addWord("a");
        search.addWord("a");

        assertFalse(search.search(".a"));
        assertFalse(search.search("a."));
    }

}
