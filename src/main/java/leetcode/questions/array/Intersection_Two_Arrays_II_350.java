package leetcode.questions.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

 Note:
 Each element in the result should appear as many times as it shows in both arrays.
 The result can be in any order.
 Follow up:
 What if the given array is already sorted? How would you optimize your algorithm? binary search each...i should be able to linearly scan as well
 What if nums1's size is small compared to nums2's size? Which algorithm is better? second
 What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

    if its sorted, then we can stream and match
 -----------------------------------------------------------------------------------------------------------------------

 Have two pointers, move until they match one or the other...and apparently they can be in different order
 Might as well use a dictionary, increment count in one array and decrement in the other

 */
public class Intersection_Two_Arrays_II_350 {

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> intersections = new ArrayList<>();
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

        int[] result = new int[intersections.size()];
        for (int index = 0; index < intersections.size(); index++) {
            result[index] = intersections.get(index);
        }
        return result;
    }

}
