package leetcode.questions.data_structures.treemap;

import java.util.*;

/**
 Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
 Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ? j), inclusive.

 Note:
 A naive algorithm of O(n2) is trivial. You MUST do better than that.

 Example:
 Given nums = [-2, 5, -1], lower = -2, upper = 2,
 Return 3.
 The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.

 -----------------------------------------------------------------------------------------------------

 If i do a running sum
 -2, 3, 2

 And do the sum closest to k...using treeset and just iterate for all ranges of lower - upper?

 Looks like treemap has submap function which simplifies above operation

 */

public class Count_Range_Sum_327 {

    public static int countRangeSum(int[] nums, int lower, int upper) {
        if ((nums == null) || (nums.length == 0)) {
            return 0;
        }

        long sum = 0;
        TreeMap<Long, List<Integer>> lookup = new TreeMap<>();
        lookup.put(sum, lookup.getOrDefault(sum, new ArrayList<>()));
        lookup.get(sum).add(-1);// so we can get the very first one

        int count = 0;
        for (int index = 0; index < nums.length; index++) {
            int num = nums[index];

            sum += num;

            // looks like treemap has submap funciton
            Map<Long, List<Integer>> submap = lookup.subMap(sum - upper, true, sum - lower, true);
            for (List<Integer> indexes : submap.values()) {
                count += indexes.size();
            }

            lookup.put(sum, lookup.getOrDefault(sum, new ArrayList<>()));
            lookup.get(sum).add(index);
        }
        return count;
    }

}
