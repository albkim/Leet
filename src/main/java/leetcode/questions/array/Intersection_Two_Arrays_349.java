package leetcode.questions.array;

import java.util.*;

/**
 Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

 Note:
 Each element in the result must be unique.
 The result can be in any order.

 -------------------------------------------------------------------------------------------------

 Use set to make the intersection unique

 Not entirely sure what this asks...but based on code, it's asking for unique overlapping numbers

 */
public class Intersection_Two_Arrays_349 {

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> intersections = new HashSet<>();
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums1) {
            if (counts.containsKey(num)) {
                counts.put(num, counts.get(num) + 1);
            }
            else {
                counts.put(num, 1);
            }
        }

        for (int num : nums2) {
            if (counts.containsKey(num)) {
                intersections.add(num);
                int newCount = counts.get(num) - 1;
                if (newCount == 0) {
                    counts.remove(num);
                }
                else {
                    counts.put(num, newCount);
                }
            }
        }

        int index = 0;
        int[] result = new int[intersections.size()];
        for (int num : intersections) {
            result[index] = num;
            index++;
        }
        return result;
    }

}
