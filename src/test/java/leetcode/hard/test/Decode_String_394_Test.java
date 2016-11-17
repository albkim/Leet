package leetcode.hard.test;

import leetcode.hard.Decode_String_394;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 11/9/2016.
 */
public class Decode_String_394_Test {

    @Test
    public void testSimple() {
        assertEquals("aaabcbc", Decode_String_394.decodeString("3[a]2[bc]"));
    }

    @Test
    public void testSimple1() {
        assertEquals("accaccacc", Decode_String_394.decodeString("3[a2[c]]"));
    }

    @Test
    public void testSimple2() {
        assertEquals("abcabccdcdcdef", Decode_String_394.decodeString("2[abc]3[cd]ef"));
    }

}
