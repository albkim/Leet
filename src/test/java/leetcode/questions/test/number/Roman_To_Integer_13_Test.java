package leetcode.questions.test.number;

import leetcode.questions.number.Roman_To_Integer_13;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/5/2016.
 */
public class Roman_To_Integer_13_Test {

    @Test
    public void testSimple() {
        assertEquals(123, Roman_To_Integer_13.romanToInt("CXXIII"));
        assertEquals(163, Roman_To_Integer_13.romanToInt("CLXIII"));
        assertEquals(193, Roman_To_Integer_13.romanToInt("CXCIII"));
        assertEquals(324, Roman_To_Integer_13.romanToInt("CCCXXIV"));
    }
}
