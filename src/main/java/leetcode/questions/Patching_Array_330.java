package leetcode.questions;

/**
 Given a sorted positive integer array nums and an integer n, add/patch elements to the array such that any
 number in range [1, n] inclusive can be formed by the sum of some elements in the array.
 Return the minimum number of patches required.

 Example 1:
 nums = [1, 3], n = 6
 Return 1.

 Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
 Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
 Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
 So we only need 1 patch.

 Example 2:
 nums = [1, 5, 10], n = 20
 Return 2.
 The two patches can be [2, 4].

 Example 3:
 nums = [1, 2, 2], n = 5
 Return 0.

 ----------------------------------------------------------------------------------------------

 Since it's sorted, we need to generate what number if covers as we iterate the list
 e.g., [1,2,3,7]
 when we have 1, we know it can cover 1
 when we add 2, we know it can cover 1, 2, 3
 when we add 3, we know it can cover 1, 2, 3, 4, 5, 6

 If we know all possible numbers are covered up to a range, we can just add the current number and extend the range.
 (since current number + [1,2,3,...n] can cover all numbers from 1 -> (current + n)

 */
public class Patching_Array_330 {

    public static int minPatches(int[] nums, int n) {
        if (nums == null) {
            nums = new int[] {};
        }

        int patches = 0;
        long completeCoveredRange = 0;
        for (int num : nums) {
            // we need to patch, the best candidate is completedCoveredRange + 1
            while ((completeCoveredRange + 1 < num) && (completeCoveredRange < n)) {
                patches++;
                completeCoveredRange += completeCoveredRange + 1;
            }
            completeCoveredRange += num;
        }

        // now we haven't reached n, we need to keep patching
        while (completeCoveredRange < n) {
            patches++;
            completeCoveredRange += completeCoveredRange + 1;
        }

        return patches;
    }

}
