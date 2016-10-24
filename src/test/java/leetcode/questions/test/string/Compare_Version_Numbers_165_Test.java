package leetcode.questions.test.string;

import leetcode.questions.string.Compare_Version_Numbers_165;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/9/2016.
 */
public class Compare_Version_Numbers_165_Test {

    @Test
    public void testEdge() {
        assertEquals(0, Compare_Version_Numbers_165.compareVersion("1", "1.0"));
    }

    @Test
    public void testSimple() {
        assertEquals(0, Compare_Version_Numbers_165.compareVersion("1.2.3.4", "1.2.3.4"));
        assertEquals(-1, Compare_Version_Numbers_165.compareVersion("0.1", "1.1"));
        assertEquals(-1, Compare_Version_Numbers_165.compareVersion("1.1", "1.2"));
        assertEquals(-1, Compare_Version_Numbers_165.compareVersion("1.2", "13.37"));
    }

}
