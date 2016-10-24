package leetcode.test.questions.binary_search;

import leetcode.questions.binary_search.Number_Higher_Lower_374;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by albertk on 8/26/16.
 */
public class Number_Higher_Lower_374_Test {

    @Test(expected = IllegalStateException.class)
    public void testNotFound() {
        Number_Higher_Lower_374 q = new Number_Higher_Lower_374(11);
        q.guessNumber(10);
    }

    @Test
    public void testBounds() {
        Number_Higher_Lower_374 q = new Number_Higher_Lower_374(1);
        assertEquals(1, q.guessNumber(10));

        q = new Number_Higher_Lower_374(10);
        assertEquals(10, q.guessNumber(10));
    }

    @Test
    public void testValid() {
        Number_Higher_Lower_374 q = new Number_Higher_Lower_374(6);
        assertEquals(6, q.guessNumber(10));
    }

}
