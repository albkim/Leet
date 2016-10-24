package leetcode.questions.binary_search;

/**
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.


 ---------------------------------------------------------------------------------

 Minimum by definition happens at the point of rotation

 If there is no rotation, pick the lowest (no rotation or pick the sub array which doesn't have rotation)

 */
public class Find_Minimum_Rotated_Sorted_Array_153 {

    public static int findMin(int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return -1;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int start = 0;
        int end = nums.length - 1;

        int min = Integer.MAX_VALUE;

        while(start <= end) {
            int mid = start + ((end - start) >> 1);

            // find rotation
            if ((nums[start] <= nums[mid]) && (nums[mid] <= nums[end])) {
                // no rotation
                min = Math.min(min, nums[start]);
                break;
            }

            if ((nums[start] > nums[mid]) && (nums[mid] < nums[end])) {
                // rotation is on the left
                min = Math.min(min, nums[mid]);
                end = mid - 1;
            }
            else {
                min = Math.min(min, nums[start]);
                start = mid + 1;
            }
        }

        return min;
    }

}
