package leetcode.questions.test.data_structures.trie;

import leetcode.questions.data_structures.trie.Implement_Trie_Prefix_Tree_208;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/12/2016.
 */
public class Implement_Trie_Prefix_Tree_208_Test {

    @Test
    public void testSimple() {
        Implement_Trie_Prefix_Tree_208 trie = new Implement_Trie_Prefix_Tree_208();

        trie.insert("a");

        assertTrue(trie.search("a"));
        assertTrue(trie.startsWith("a"));
    }

}
