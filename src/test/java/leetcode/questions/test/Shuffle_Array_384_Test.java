package leetcode.questions.test;

import org.apache.commons.math3.util.CombinatoricsUtils;
import org.junit.Test;
import leetcode.questions.Shuffle_Array_384;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class Shuffle_Array_384_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testNullArray() {
        new Shuffle_Array_384(null);
    }

    @Test
    public void testShuffle() {
        // the total number of variation is n!
        // for [1,2,3] it will be 3 * 2 * 1
        // 1 [2 [3], 3 [2]]
        // 2 [1 [3], 3 [1]]
        // 3 [1 [2], 2 [1]]

        int[] numbers = {1, 2, 3};

        Shuffle_Array_384 solution = new Shuffle_Array_384(numbers);

        List<Integer> result = Arrays.stream(solution.shuffle()).boxed().collect(Collectors.toList());

        assertEquals(numbers.length, result.size());
        assertTrue(result.contains(numbers[0]));
        assertTrue(result.contains(numbers[1]));
        assertTrue(result.contains(numbers[2]));
    }

    @Test
    public void testShuffleDistribution() {
        // the total number of variation is n!
        // for [1,2,3] it will be 3 * 2 * 1
        // 1 [2 [3], 3 [2]]
        // 2 [1 [3], 3 [1]]
        // 3 [1 [2], 2 [1]]

        int[] numbers = {1, 2, 3};

        // good test number for distribution would be n! * 10000
        long iterationCount = CombinatoricsUtils.factorial(numbers.length) * 10000;

        // Using List<int> allows one to use it as a key in map without having it do a reference equal
        Map<List<Integer>, Integer> lookup = new HashMap<>();

        Shuffle_Array_384 solution = new Shuffle_Array_384(numbers);

        for (int count = 0; count < iterationCount; count++) {
            List<Integer> key = Arrays.stream(solution.shuffle()).boxed().collect(Collectors.toList());
            if (lookup.containsKey(key)) {
                lookup.put(key, lookup.get(key) + 1);
            }
            else {
                lookup.put(key, 1);
            }
        }

        // lookup should contain all valid combinations
        assertEquals(CombinatoricsUtils.factorial(numbers.length), lookup.size());

        int count = 0;
        int total = 0;
        for(Map.Entry<List<Integer>, Integer> entry : lookup.entrySet()) {
            total += entry.getValue().intValue();
            count++;
        }

        double deviationTotal = 0;
        double avg = total / (double)count;
        for(Map.Entry<List<Integer>, Integer> entry : lookup.entrySet()) {
            deviationTotal += Math.pow(entry.getValue() - avg, 2d);
        }

        double variance = deviationTotal / (double)count;

        assertEquals(0d, Math.sqrt(variance) / iterationCount, 0.5d);
    }

    @Test
    public void testReset() {
        // the total number of variation is n!
        // for [1,2,3] it will be 3 * 2 * 1
        // 1 [2 [3], 3 [2]]
        // 2 [1 [3], 3 [1]]
        // 3 [1 [2], 2 [1]]

        int[] numbers = {1, 2, 3};

        Shuffle_Array_384 solution = new Shuffle_Array_384(numbers);

        solution.shuffle();

        int[] result = solution.reset();

        assertEquals(numbers.length, result.length);
        assertEquals(numbers[0], result[0]);
        assertEquals(numbers[1], result[1]);
        assertEquals(numbers[2], result[2]);
    }

}
