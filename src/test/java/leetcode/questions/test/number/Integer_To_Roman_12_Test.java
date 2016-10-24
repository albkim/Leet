package leetcode.questions.test.number;

import leetcode.questions.number.Integer_To_Roman_12;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/5/2016.
 */
public class Integer_To_Roman_12_Test {

    @Test
    public void testSimple() {
        assertEquals("CXXIII", Integer_To_Roman_12.intToRoman(123));
        assertEquals("CLXIII", Integer_To_Roman_12.intToRoman(163));
        assertEquals("CXCIII", Integer_To_Roman_12.intToRoman(193));
        assertEquals("CCCXXIV", Integer_To_Roman_12.intToRoman(324));
    }

}
