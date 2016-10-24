package leetcode.questions.pointer_scan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 Given an integer array of size n, find all elements that appear more than ? n/3 ? times.
 The algorithm should run in linear time and in O(1) space.

 -----------------------------------------------------------------------------------------------

 Can't seem to use the usual method since that requires more than 50%...

 */
public class Majority_Element_II_229 {

    public static List<Integer> majorityElement(int[] nums) {
        return majorityElementGeneric(nums, 2);
    }

    public static List<Integer> majorityElementGeneric(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> duplicateCheck = new HashSet<>();

        if (nums.length <= k) {
            for (int num : nums) {
                if (!duplicateCheck.contains(num)) {
                    result.add(num);
                }
                duplicateCheck.add(num);
            }
            return result;
        }

        int[] candidates = new int[k];
        int[] counts = new int[k];

        for (int num : nums) {
            boolean found = false;
            for (int index = 0; index < k; index++) {
                if (num == candidates[index]) {
                    counts[index]++;
                    found = true;
                    break;
                }
            }
            if (found) {
                continue;
            }
            for (int index = 0; index < k; index++) {
                if (counts[index] == 0) {
                    candidates[index] = num;
                    counts[index]++;
                    found = true;
                    break;
                }
            }
            if (found) {
                continue;
            }
            for (int index = 0; index < k; index++) {
                counts[index]--;
            }
        }

        duplicateCheck.clear();
        for (int candidate : candidates) {
            int count = 0;
            for (int num : nums) {
                if (candidate == num) {
                    count++;
                }
            }

            if ((count > (nums.length / (k + 1))) && (!duplicateCheck.contains(candidate))) {
                result.add(candidate);
            }
            duplicateCheck.add(candidate);
        }

        return result;
    }

}
