package leetcode.questions.pointer_scan;

/**
 Implement next permutation, which rearranges number into the lexicographically next greater permutation of number.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 1,2,3 ? 1,3,2 -> 2,1,3 -> 2,3,1 -> 3,1,2 -> 3,2,1 -> 1,2,3
 1,2,3,4 -> 1,2,4,3 -> 1,3,2,4 -> 1,3,4,2 -> 1,4,2,3 -> 1,4,3,2 -> 2,1,3,4 -> 2,3,1,4
 1,1,5 ? 1,5,1

 Seems like the pattern is to find the last increasing pair and move the bigger one in front of the small one...then sort the rest
 find the first number from the back which is not descending, then find the smallest number greater than this number, sort the rest (since already descending just swap)
 If the pattern is not found (every number is decreasing, then I need to resort the sequence)
 How to handle two equal number
 */
public class Next_Permutation_31 {

    public static void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        int patternIndex = -1;
        for (int index = nums.length - 1; index > 0; index--) {
            if (nums[index] > nums[index - 1]) {
                patternIndex = index - 1;
                break;
            }
        }

        int left = 0;
        if (patternIndex > -1) {
            int smallest = Integer.MAX_VALUE;
            int smallestIndex = -1;
            // probably could do binary search...
            for (int index = patternIndex + 1; index < nums.length; index++) {
                if ((nums[index] > nums[patternIndex]) && (nums[index] <= smallest)) {
                    smallest = nums[index];
                    smallestIndex = index;
                }
            }

            int temp = nums[patternIndex];
            nums[patternIndex] = nums[smallestIndex];
            nums[smallestIndex] = temp;

            left = patternIndex + 1;
        }

        // resort - in this case we just need to swap from edge
        int right = nums.length - 1;
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }

}
