package leetcode.questions.array;

/**
 Given an array and a value, remove all instances of that value in place and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 Example:
 Given input array nums = [3,2,2,3], val = 3

 Your function should return length = 2, with the first two elements of nums being 2.





 -----------------------------------------------------------------------------------------


 as we scan left to right, if the current number is not the number to be removed, swap it with last good position

 */
public class Remove_Element_27 {

    public static int removeElement(int[] nums, int val) {
        int replaceIndex = 0;

        for(int index = 0; index < nums.length; index++) {
            if (nums[index] != val) {
                nums[replaceIndex] = nums[index];
                replaceIndex++;
            }
        }

        return replaceIndex;
    }

}

