package leetcode.questions.test.pointer_scan;

import leetcode.questions.pointer_scan.Substring_With_Concatenation_All_Words_30;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/7/2016.
 */
public class Substring_With_Concatenation_All_Words_30_Test {

    @Test
    public void testValidation() {
        assertEquals(0, Substring_With_Concatenation_All_Words_30.findSubstring("", new String[]{}).size());
        assertEquals(0, Substring_With_Concatenation_All_Words_30.findSubstring("a", new String[]{"abc"}).size());
    }

    @Test
    public void testSimple() {
        List<Integer> result = Substring_With_Concatenation_All_Words_30.findSubstring("abc", new String[] {"abc"});
        assertEquals(1, result.size());
        assertEquals(0, result.get(0).intValue());
    }

    @Test
    public void testSample() {
        List<Integer> result = Substring_With_Concatenation_All_Words_30.findSubstring("barfoothefoobarman", new String[] {"foo", "bar"});
        assertEquals(2, result.size());
        assertEquals(0, result.get(0).intValue());
        assertEquals(9, result.get(1).intValue());
    }

    @Test
    public void testRepeat() {
        List<Integer> result = Substring_With_Concatenation_All_Words_30.findSubstring("abcabc", new String[] {"abc"});
        assertEquals(2, result.size());
        assertEquals(0, result.get(0).intValue());
        assertEquals(3, result.get(1).intValue());
    }

    @Test
    public void testCombo() {
        List<Integer> result = Substring_With_Concatenation_All_Words_30.findSubstring("abcefg", new String[] {"abc", "efg"});
        assertEquals(1, result.size());
        assertEquals(0, result.get(0).intValue());
    }

    @Test
    public void testReverse() {
        List<Integer> result = Substring_With_Concatenation_All_Words_30.findSubstring("efgabc", new String[] {"abc", "efg"});
        assertEquals(1, result.size());
        assertEquals(0, result.get(0).intValue());
    }

    @Test
    public void testReset() {
        List<Integer> result = Substring_With_Concatenation_All_Words_30.findSubstring("abceabc", new String[] {"abc"});
        assertEquals(2, result.size());
        assertEquals(0, result.get(0).intValue());
        assertEquals(4, result.get(1).intValue());
    }

    @Test
    public void testComplex() {
        List<Integer> result = Substring_With_Concatenation_All_Words_30.findSubstring("wordgoodgoodgoodbestword", new String[] {"word","good","best","good"});
        assertEquals(1, result.size());
        assertEquals(8, result.get(0).intValue());
    }


}
