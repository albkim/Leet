package leetcode.questions.test.pointer_scan;

import leetcode.questions.pointer_scan.Implement_StrStr_28;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/6/2016.
 */
public class Implement_StrStr_28_Test {

    @Test
    public void testInvalidInput() {
        assertEquals(-1, Implement_StrStr_28.strStr("abc", "abcdef"));
    }

    @Test
    public void testNotFound() {
        assertEquals(-1, Implement_StrStr_28.strStr("abc", "ef"));
    }

    @Test
    public void testEdge1() {
        assertEquals(0, Implement_StrStr_28.strStr("abc", "ab"));
    }

    @Test
    public void testEdge2() {
        assertEquals(1, Implement_StrStr_28.strStr("abc", "bc"));
    }

    @Test
    public void testSimple() {
        assertEquals(1, Implement_StrStr_28.strStr("abcd", "bc"));
    }

    @Test
    public void testComplex() {
        assertEquals(3, Implement_StrStr_28.strStr("ababbbbaaabbbaaa", "bbbb"));
    }

}
