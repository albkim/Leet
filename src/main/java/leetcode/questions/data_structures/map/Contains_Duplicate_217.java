package leetcode.questions.data_structures.map;

import java.util.HashSet;
import java.util.Set;

/**
 Given an array of integers, find if the array contains any duplicates.
 Your function should return true if any value appears at least twice in the array,
 and it should return false if every element is distinct.

 -------------------------------------------------------------------------------------------

 Use set to check if a number already exists

 */
public class Contains_Duplicate_217 {

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> lookup = new HashSet<>();

        for (int num : nums) {
            if (lookup.contains(num)) {
                return true;
            }
            lookup.add(num);
        }

        return false;
    }

}
