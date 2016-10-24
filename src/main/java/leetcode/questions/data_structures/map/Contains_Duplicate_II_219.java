package leetcode.questions.data_structures.map;

import java.util.*;

/**
 Given an array of integers and an integer k, find out whether there are two distinct indices i and j
 in the array such that nums[i] = nums[j] and the difference between i and j is at most k.

 --------------------------------------------------------------------------------------------------------

 Use a map of numbers and indexes. Once we find a dupe, we can linearly scan the indexes until we find or
 the difference is beyond k

 */
public class Contains_Duplicate_II_219 {

    public static boolean ContainsNearbyDuplicate(int[] nums, int k) {
        if ((nums == null) || (nums.length == 0)) {
            return false;
        }

        Map<Integer, List<Integer>> lookup = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            if (lookup.containsKey(nums[index])) {
                List<Integer> indexes = lookup.get(nums[index]);
                for (int dIndex = indexes.size() - 1; dIndex >= 0; dIndex--) {
                    if (index - indexes.get(dIndex) <= k) {
                        return true;
                    }
                }
                indexes.add(index);
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
