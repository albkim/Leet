package leetcode.questions.test.back_tracking;

import leetcode.questions.back_tracking.Additive_Number_306;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/18/2016.
 */
public class Additive_Number_306_Test {

    @Test
    public void testSimple() {
        assertTrue(Additive_Number_306.isAdditiveNumber("112358"));
    }

    @Test
    public void testSimple1() {
        assertTrue(Additive_Number_306.isAdditiveNumber("199100199"));
    }

    @Test
    public void testSimple2() {
        assertFalse(Additive_Number_306.isAdditiveNumber("111"));
    }

    @Test
    public void testSimple3() {
        assertFalse(Additive_Number_306.isAdditiveNumber("19910011992"));
    }

}
