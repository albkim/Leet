package leetcode.hard;

import java.util.*;

/**
 Given a non-empty array of integers, return the k most frequent elements.

 For example,
 Given [1,1,1,2,2,3] and k = 2, return [1,2].

 Note:
 You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

 ---------------------------------------------------------------------------------------------------

 Use a map to track frequency of occurrence. Then assign each number into a bucket of frequencies. Then it's a matter
 of counting k from top frequency

 */
public class Top_K_Frequent_Elements_347 {

    public static List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int num : nums) {
            int count = frequencies.getOrDefault(num, 0) + 1;
            frequencies.put(num, count);
        }

        Queue<int[]> order = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (int number : frequencies.keySet()) {
            order.add(new int[] {number, frequencies.get(number)});
        }

        List<Integer> result = new ArrayList<>();
        int total = Math.min(k, order.size());
        for(int count = 0; count < total; count++) {
            result.add(order.poll()[0]);
        }
        return result;
    }

}
