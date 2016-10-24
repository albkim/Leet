package leetcode.questions.test.data_structures.graph;

import leetcode.questions.data_structures.graph.Word_Ladder_127;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/4/2016.
 */
public class Word_Ladder_127_Test {

    @Test
    public void testSimple() {
        Set<String> wordList = new HashSet<>(Arrays.asList("hot","dot","dog","lot","log"));
        assertEquals(5, Word_Ladder_127.ladderLength("hit", "cog", wordList));
    }

}
