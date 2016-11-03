package leetcode.hard.test;

import leetcode.hard.Top_K_Frequent_Elements_347;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by albertk on 10/5/16.
 */
public class Top_K_Frequent_Elements_347_Test {

    @Test
    public void testSimple() {
        List<Integer> result = Top_K_Frequent_Elements_347.topKFrequent(new int[] {1,1,1,2,2,3}, 2);

        assertEquals(2, result.size());

        assertEquals(1, result.get(0).intValue());
        assertEquals(2, result.get(1).intValue());
    }

    @Test
    public void testSimple2() {
        List<Integer> result = Top_K_Frequent_Elements_347.topKFrequent(new int[] {1,1,2,2,3,3}, 2);

        assertEquals(2, result.size());

        assertEquals(1, result.get(0).intValue());
        assertEquals(3, result.get(1).intValue());
    }

}
