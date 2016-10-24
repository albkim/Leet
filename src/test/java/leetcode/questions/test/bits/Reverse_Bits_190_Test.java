package leetcode.questions.test.bits;

import leetcode.questions.bits.Reverse_Bits_190;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/11/2016.
 */
public class Reverse_Bits_190_Test {

    @Test
    public void testSimple() {
        assertEquals(964176192, Reverse_Bits_190.reverseBits(43261596));
    }

}
