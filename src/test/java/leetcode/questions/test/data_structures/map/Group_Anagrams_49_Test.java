package leetcode.questions.test.data_structures.map;

import leetcode.questions.data_structures.map.Group_Anagrams_49;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/14/2016.
 */
public class Group_Anagrams_49_Test {

    @Test
    public void testSimple() {
        List<List<String>> result = Group_Anagrams_49.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});

        assertEquals(3, result.size());

        assertEquals(3, result.get(0).size());
        assertEquals("eat", result.get(0).get(0));
        assertEquals("tea", result.get(0).get(1));
        assertEquals("ate", result.get(0).get(2));

        assertEquals(1, result.get(1).size());
        assertEquals("bat", result.get(1).get(0));

        assertEquals(2, result.get(2).size());
        assertEquals("tan", result.get(2).get(0));
        assertEquals("nat", result.get(2).get(1));
    }

}
