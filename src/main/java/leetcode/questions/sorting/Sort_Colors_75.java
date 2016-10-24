package leetcode.questions.sorting;

/**
 Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
 with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note:
 You are not suppose to use the library's sort function for this problem.


 Follow up:
 A rather straight forward solution is a two-pass algorithm using counting sort.
 First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

 Could you come up with an one-pass algorithm using only constant space?


 ---------------------------------------------------------------------------------------------------

 This is similar to dutch flag problem where you have three pointers (sorted, second, current) and keep swapping

 000011111XXXXXXXX22222
    |     |       |


 */
public class Sort_Colors_75 {

    public static void sortColors(int[] nums) {
        int zeroPointer = 0;
        int twoPointer = nums.length - 1;
        int current = 0;

        while (current <= twoPointer) {
            if (nums[current] == 0) {
                swap(nums, zeroPointer, current);
                zeroPointer++;
                current++; // important
            }
            else if (nums[current] == 2) {
                swap(nums, twoPointer, current);
                twoPointer--;
            }
            else {
                // has to be one...move the current
                current++;
            }
        }
    }

    private static void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

}
