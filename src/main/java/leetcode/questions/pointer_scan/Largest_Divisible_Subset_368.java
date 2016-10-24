package leetcode.questions.pointer_scan;

import java.util.*;

/**
 Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of
 elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
 If there are multiple solutions, return any subset is fine.
 Example 1:
 nums: [1,2,3]

 Result: [1,2] (of course, [1,3] will also be ok)

 Example 2:
 nums: [1,2,4,8]

 Result: [1,2,4,8]
 */
public class Largest_Divisible_Subset_368 {

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }

        // sort this so we can try smallest to largest
        Arrays.sort(nums);

        // since all numbers have to be distinct we can safely use the number itself as a key
        Map<Integer, List<Integer>> maxNumbers= new HashMap<>();

        // some basic math, if N % x = 0 and M % N = 0 then M % x = 0, so we can try
        // largest from the subset against next number and guarantee that smaller numbers
        // in the subset would satisfy

        // from the back, try all possible combination from current left to right, and find the longest and store it
        for (int index = nums.length - 1; index >= 0; index--) {
            int max = 0;
            int maxLengthNumber = 0;
            for (int candidateIndex = index + 1; candidateIndex < nums.length; candidateIndex++) {
                if (nums[candidateIndex] % nums[index] == 0) {
                    // this is a valid set, is this the max though?
                    if (maxNumbers.get(nums[candidateIndex]).size() > max) {
                        max = maxNumbers.get(nums[candidateIndex]).size();
                        maxLengthNumber = nums[candidateIndex];
                    }
                }
            }

            // new max length set for current number is current number + whatever is longest in terms of previous search
            List<Integer> newSet = (max > 0) ? new ArrayList<>(maxNumbers.get(maxLengthNumber)) : new ArrayList<>();

            // add current
            newSet.add(0, nums[index]);

            // add to cache
            maxNumbers.put(nums[index], newSet);
        }

        List<Integer> maxLengthSet = new ArrayList<>();
        for (List<Integer> candidate : maxNumbers.values()) {
            if (candidate.size() > maxLengthSet.size()) {
                maxLengthSet = candidate;
            }
        }

        return maxLengthSet;
    }

}
