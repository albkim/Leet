package leetcode.questions.test.pointer_scan;

import leetcode.questions.pointer_scan.Repeated_DNA_Sequences_187;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/10/2016.
 */
public class Repeated_DNA_Sequences_187_Test {

    @Test
    public void testEdge() {
        List<String> result = Repeated_DNA_Sequences_187.findRepeatedDnaSequences("AAAAAAAAAAA");

        assertEquals(1, result.size());

        assertEquals("AAAAAAAAAA", result.get(0));
    }

    @Test
    public void testSimple() {
        List<String> result = Repeated_DNA_Sequences_187.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");

        assertEquals(2, result.size());

        assertEquals("AAAAACCCCC", result.get(0));
        assertEquals("CCCCCAAAAA", result.get(1));
    }

}
