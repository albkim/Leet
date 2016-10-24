package leetcode.questions.test.bits;

import leetcode.questions.bits.UTF_8_Validation_393;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/23/2016.
 */
public class UTF_8_Validation_393_Test {

    @Test
    public void testSimple() {
        assertTrue(UTF_8_Validation_393.validUtf8(new int[]{197, 130, 1}));
        assertFalse(UTF_8_Validation_393.validUtf8(new int[]{235, 140, 4}));
    }

    @Test
    public void testSimple1() {
        assertFalse(UTF_8_Validation_393.validUtf8(new int[]{145}));
    }

    @Test
    public void testEdge() {
        assertFalse(UTF_8_Validation_393.validUtf8(new int[]{255}));
    }

}
