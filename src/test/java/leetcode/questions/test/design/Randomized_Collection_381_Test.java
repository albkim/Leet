package leetcode.questions.test.design;

import leetcode.questions.design.Randomized_Collection_381;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by albertk on 8/22/16.
 */
public class Randomized_Collection_381_Test {

    @Test
    public void testInsert() {
        Randomized_Collection_381 collection = new Randomized_Collection_381();

        assertTrue(collection.insert(1));
        assertTrue(collection.insert(2));
    }

    @Test
    public void testInsertDupes() {
        Randomized_Collection_381 collection = new Randomized_Collection_381();

        assertTrue(collection.insert(1));
        assertFalse(collection.insert(1));
        assertFalse(collection.insert(1));
    }

    @Test
    public void testRemoveNotFound() {
        Randomized_Collection_381 collection = new Randomized_Collection_381();

        assertFalse(collection.remove(1));
    }

    @Test
    public void testRemoveNotFoundCorrect() {
        Randomized_Collection_381 collection = new Randomized_Collection_381();

        assertTrue(collection.insert(1));
        assertTrue(collection.remove(1));
        assertFalse(collection.remove(1));
    }

    @Test
    public void testRemoveFound() {
        Randomized_Collection_381 collection = new Randomized_Collection_381();

        assertTrue(collection.insert(1));
        assertTrue(collection.remove(1));
    }

    @Test
    public void testRemoveDupes() {
        Randomized_Collection_381 collection = new Randomized_Collection_381();

        assertTrue(collection.insert(1));
        assertFalse(collection.insert(1));
        assertTrue(collection.remove(1));
        assertTrue(collection.remove(1));
    }

    @Test
    public void testRemoveReplace() {
        Randomized_Collection_381 collection = new Randomized_Collection_381();

        assertTrue(collection.insert(1));
        assertTrue(collection.insert(2));
        assertTrue(collection.remove(1));

        assertEquals(2, collection.getRandom());
    }

    @Test
    public void testRemoveLast() {
        Randomized_Collection_381 collection = new Randomized_Collection_381();

        assertTrue(collection.insert(1));
        assertTrue(collection.insert(2));
        assertTrue(collection.remove(2));

        assertEquals(1, collection.getRandom());
    }

    @Test
    public void testRemoveComplex() {
        Randomized_Collection_381 collection = new Randomized_Collection_381();

        assertTrue(collection.insert(1));
        assertFalse(collection.insert(1));
        assertTrue(collection.insert(2));
        assertFalse(collection.insert(1));
        assertFalse(collection.insert(2));
        assertFalse(collection.insert(2));
        assertTrue(collection.remove(1));
        assertTrue(collection.remove(2));
        assertTrue(collection.remove(2));
        assertTrue(collection.remove(2));
    }

    @Test
    public void testShuffleDistribution() {
        Randomized_Collection_381 collection = new Randomized_Collection_381();
        collection.insert(1);
        collection.insert(2);
        collection.insert(3);

        // good test number for distribution would be n! * 10000
        long iterationCount = 3 * 10000;

        Map<Integer, Integer> lookup = new HashMap<>();

        for (int count = 0; count < iterationCount; count++) {
            int key = collection.getRandom();
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

    @Test
    public void testShuffleDistributionDupes() {
        Randomized_Collection_381 collection = new Randomized_Collection_381();
        collection.insert(1);
        collection.insert(1);
        collection.insert(2);

        // good test number for distribution would be n! * 10000
        long iterationCount = 3 * 10000;

        Map<Integer, Integer> lookup = new HashMap<>();

        for (int count = 0; count < iterationCount; count++) {
            int key = collection.getRandom();
            if (lookup.containsKey(key)) {
                lookup.put(key, lookup.get(key) + 1);
            }
            else {
                lookup.put(key, 1);
            }
        }

        // lookup should contain all nodes
        assertEquals(2, lookup.size());
        assertEquals(2d, lookup.get(1) / (1d * lookup.get(2)), 0.1d);
    }

}
