package leetcode.questions.pointer_scan;

/**
 Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.


 -----------------------------------------------------------------------------------------


 Simple keep track of previous + in place replacement by keeping the last good index

 */
public class Remove_Duplicates_Sorted_Array_26 {

    public static int removeDuplicates(int[] nums) {
        int replaceIndex = 0;

        Integer previous = null;
        for(int index = 0; index < nums.length; index++) {
            if ((previous != null) && (previous.intValue() == nums[index])) {
                continue;
            }

            nums[replaceIndex] = nums[index];
            previous = nums[index];
            replaceIndex++;
        }

        return replaceIndex;
    }

}
