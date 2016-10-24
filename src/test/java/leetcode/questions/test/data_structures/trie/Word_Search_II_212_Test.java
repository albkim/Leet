package leetcode.questions.test.data_structures.trie;

import leetcode.questions.data_structures.trie.Word_Search_II_212;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/12/2016.
 */
public class Word_Search_II_212_Test {

    @Test
    public void testSimple() {
        char[][] board = new char[][] {
                new char[] {'o','a','a','n'},
                new char[] {'e','t','a','e'},
                new char[] {'i','h','k','r'},
                new char[] {'i','f','l','v'}
        };

        String[] words = new String[] {"oath","pea","eat","rain"};

        List<String> result = Word_Search_II_212.findWords(board, words);

        assertEquals(2, result.size());

        assertEquals("oath", result.get(0));
        assertEquals("eat", result.get(1));
    }

    @Test
    public void testSimple1() {
        char[][] board = new char[][] {
                "ab".toCharArray(),
                "cd".toCharArray()
        };

        String[] words = new String[] {"ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"};

        List<String> result = Word_Search_II_212.findWords(board, words);

        assertEquals(5, result.size());

        assertEquals("ab", result.get(0));
        assertEquals("ac", result.get(1));
        assertEquals("bd", result.get(2));
        assertEquals("ca", result.get(3));
        assertEquals("db", result.get(4));
    }

}
