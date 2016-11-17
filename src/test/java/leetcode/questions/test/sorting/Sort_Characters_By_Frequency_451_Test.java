package leetcode.questions.test.sorting;

import leetcode.questions.sorting.Sort_Characters_By_Frequency_451;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 11/9/2016.
 */
public class Sort_Characters_By_Frequency_451_Test {

    @Test
    public void testSimple() {
        assertEquals("eert", Sort_Characters_By_Frequency_451.frequencySort("tree"));
    }

    @Test
    public void testSimple1() {
        assertEquals("aaaccc", Sort_Characters_By_Frequency_451.frequencySort("cccaaa"));
    }

    @Test
    public void testSimple2() {
        assertEquals("bbAa", Sort_Characters_By_Frequency_451.frequencySort("Aabb"));
    }

}
