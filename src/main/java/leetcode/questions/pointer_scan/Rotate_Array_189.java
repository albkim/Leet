package leetcode.questions.pointer_scan;

/**
 Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

 Note:
 Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

 -------------------------------------------------------------------------------------------------

 Seems like this is similar to reverse words. If we reverse entire array. Then reverse each of the sub section
 we can shift

 1,2,3,4,5,6,7 -> 7,6,5,4,3,2,1 -> 5,6,7,4,3,2,1, -> 5,6,7,1,2,3,4

 */
public class Rotate_Array_189 {

    public static void rotate(int[] nums, int k) {
        if (nums.length == 0) {
            return;
        }

        if (k > nums.length) {
            k %= nums.length;
        }

        swap(nums, 0, nums.length - 1);
        swap(nums, 0, k - 1);
        swap(nums, k, nums.length - 1);
    }

    private static void swap(int[] nums, int left, int right) {
        while(left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }

}
