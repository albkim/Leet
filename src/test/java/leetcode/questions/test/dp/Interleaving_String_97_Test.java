package leetcode.questions.test.dp;

import leetcode.questions.dp.Interleaving_String_97;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/30/2016.
 */
public class Interleaving_String_97_Test {

    @Test
    public void testSimple() {
        assertTrue(Interleaving_String_97.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        assertFalse(Interleaving_String_97.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }

    @Test
    public void testComplex() {
        assertFalse(Interleaving_String_97.isInterleave("db", "b", "cbb"));
        assertTrue(Interleaving_String_97.isInterleave("aabc", "abad", "aabcabad"));
    }

    @Test
    public void testEdge() {
        assertFalse(Interleaving_String_97.isInterleave("a", "", "c"));
        assertFalse(Interleaving_String_97.isInterleave("", "a", "c"));
        assertTrue(Interleaving_String_97.isInterleave("a", "", "a"));
        assertTrue(Interleaving_String_97.isInterleave("", "a", "a"));
    }

}
