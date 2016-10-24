package leetcode.questions.data_structures.map;

import java.util.*;

/**
 Given an array of integers, find out whether there are two distinct indices i and j in the array such that the
 difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.

 --------------------------------------------------------------------------------------------------------------

 Similar to II, use the treemap

 */
public class Contains_Duplicate_III_220 {

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if ((nums == null) || (nums.length == 0)) {
            return false;
        }

        TreeMap<Integer, List<Integer>> lookup = new TreeMap<>();
        for (int index = 0; index < nums.length; index++) {
            List<Integer> candidates = new ArrayList<>();
            if (lookup.containsKey(nums[index] - t)) {
                candidates.add(nums[index] - t);
            }
            if (lookup.containsKey(nums[index] + t)) {
                candidates.add(nums[index] + t);
            }
            Integer closest = lookup.ceilingKey(nums[index] - t);
            if (closest != null) {
                candidates.add(closest);
            }
            closest = lookup.ceilingKey(nums[index] + t);
            if (closest != null) {
                candidates.add(closest);
            }
            for (int candidate : candidates) {
                if (Math.abs((long)nums[index] - (long)candidate) <= t) {
                    List<Integer> indexes = lookup.get(candidate);
                    for (int dIndex = indexes.size() - 1; dIndex >= 0; dIndex--) {
                        if (index - indexes.get(dIndex) <= k) {
                            return true;
                        }
                    }
                }
            }
            if (lookup.containsKey(nums[index])) {
                lookup.get(nums[index]).add(index);
            }
            else {
                List<Integer> indexes = new ArrayList<>();
                indexes.add(index);
                lookup.put(nums[index], indexes);
            }
        }

        return false;
    }

}
