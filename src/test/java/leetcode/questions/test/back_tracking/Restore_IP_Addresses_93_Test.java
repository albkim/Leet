package leetcode.questions.test.back_tracking;

import leetcode.questions.back_tracking.Restore_IP_Addresses_93;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/28/2016.
 */
public class Restore_IP_Addresses_93_Test {

    @Test
    public void testEdge() {
        assertEquals(0, Restore_IP_Addresses_93.restoreIpAddresses("").size());
        assertEquals(0, Restore_IP_Addresses_93.restoreIpAddresses("111").size());
        assertEquals(0, Restore_IP_Addresses_93.restoreIpAddresses("1111111111111").size());
    }

    @Test
    public void testEdge2() {
        List<String> result = Restore_IP_Addresses_93.restoreIpAddresses("0000");

        assertEquals(1, result.size());
        assertEquals("0.0.0.0", result.get(0));
    }

    @Test
    public void testEdge3() {
        List<String> result = Restore_IP_Addresses_93.restoreIpAddresses("010010");

        assertEquals(2, result.size());
        assertEquals("0.10.0.10", result.get(0));
        assertEquals("0.100.1.0", result.get(1));
    }

    @Test
    public void testSimple() {
        List<String> result = Restore_IP_Addresses_93.restoreIpAddresses("25525511135");

        assertEquals(2, result.size());
        assertEquals("255.255.11.135", result.get(0));
        assertEquals("255.255.111.35", result.get(1));
    }

}
