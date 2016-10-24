package leetcode.questions.test.data_structures.stack;

import leetcode.questions.data_structures.stack.Maximal_Rectangle_85;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/23/2016.
 */
public class Maximal_Rectangle_85_Test {

    @Test
    public void testSimple() {
        assertEquals(6, Maximal_Rectangle_85.maximalRectangle(new char[][] {
                new char[] { '1', '0', '1', '0', '0' },
                new char[] { '1', '0', '1', '1', '1' },
                new char[] { '1', '1', '1', '1', '1' },
                new char[] { '1', '0', '0', '1', '0' }
        }));
    }

    @Test
    public void testSimple2() {
        assertEquals(8, Maximal_Rectangle_85.maximalRectangle(new char[][] {
                new char[] { '1', '1', '0', '1', '0', '1' },
                new char[] { '0', '1', '0', '0', '1', '1' },
                new char[] { '1', '1', '1', '1', '0', '1' },
                new char[] { '1', '1', '1', '1', '0', '1' },
        }));
    }

    @Test
    public void testComplex() {
        assertEquals(8, Maximal_Rectangle_85.maximalRectangle(new char[][] {
                "101101".toCharArray(),
                "111111".toCharArray(),
                "011011".toCharArray(),
                "111010".toCharArray(),
                "011111".toCharArray(),
                "110111".toCharArray()
        }));
    }

}
