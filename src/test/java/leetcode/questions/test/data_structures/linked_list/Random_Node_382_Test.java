package leetcode.test.questions.linked_list;

import leetcode.models.ListNode;
import leetcode.questions.data_structures.linked_list.Random_Node_382;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by albertk on 8/17/16.
 */
public class Random_Node_382_Test {

    @Test
    public void testShuffleDistribution() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        long iterationCount = 3 * 10000;

        Map<Integer, Integer> lookup = new HashMap<>();

        Random_Node_382 solution = new Random_Node_382(head);

        for (int count = 0; count < iterationCount; count++) {
            int key = solution.getRandom();
            if (lookup.containsKey(key)) {
                lookup.put(key, lookup.get(key) + 1);
            }
            else {
                lookup.put(key, 1);
            }
        }

        // lookup should contain all nodes
        assertEquals(3, lookup.size());

        int count = 0;
        int total = 0;
        for(Map.Entry<Integer, Integer> entry : lookup.entrySet()) {
            total += entry.getValue().intValue();
            count++;
        }

        double deviationTotal = 0;
        double avg = total / (double)count;
        for(Map.Entry<Integer, Integer> entry : lookup.entrySet()) {
            deviationTotal += Math.pow(entry.getValue() - avg, 2d);
        }

        double variance = deviationTotal / (double)count;

        assertEquals(0d, Math.sqrt(variance) / iterationCount, 0.5d);
    }

}
