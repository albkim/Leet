package leetcode.questions.pointer_scan;

/**
 Given an unsorted integer array, find the first missing positive integer.

 For example,
 Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.
 [1,5,2,3] return 4


 Your algorithm should run in O(n) time and uses constant space.

 It seems what they really want is the lowest positive integer not in the array, not the missing integer in the sequence
 ignoring non-positive number. This means if all number are big, the missing integer is 1.

 It seems we can destroy the passed in array so we can use it for space.
 */
public class First_Missing_Positive_41 {

    public static int firstMissingPositive(int[] nums) {
        int current = 0;

        while (current < nums.length) {
            int number = nums[current];
            int rightIndex = number - 1;

            // we have three cases here
            if (current == rightIndex) {
                current++;
            }
            else if ((0 <= rightIndex) && (rightIndex < nums.length)) {
                int temp = nums[rightIndex];
                nums[rightIndex] = number;
                nums[current] = temp;

                // there could be duplicates, which means we should just skip over this...
                if (temp == number) {
                    nums[current] = 0;
                    current++;
                    continue;
                }
            }
            else {
                // either negative or really big number, null this out and move on
                nums[current] = 0;
                current++;
            }
        }

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == 0) {
                return index + 1;
            }
        }

        return nums.length + 1;
    }

}
