package leetcode.questions.binary_search;

/**
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.


 ---------------------------------------------------------------------------------------------------------


 Binary search which requires additional logic to determine the direction, look at the end as well.
 */
public class Search_Rotated_Sorted_Array_33 {

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            else {
                // #1 - 3, 4, 5, 6, 7, 1, 2
                // #2 - 6, 7, 1, 2, 3, 4, 5

                // if mid < left then it's a left rotation (#2) else if mid > right and left rotation (#1)
                // Note the left side has = so it can handle 2 item arrays
                boolean rightRotation = (nums[left] <= nums[mid]) && (nums[mid] > nums[right]);
                // case 1
                if (rightRotation) {
                    // target is in sorted left side
                    if ((nums[left] <= target) && (target < nums[mid])) {
                        right = mid - 1;
                    }
                    else {
                        left = mid + 1;
                    }
                }
                else {
                    // target is between the sorted right side
                    if ((nums[mid] < target) && (target <= nums[right])) {
                        left = mid + 1;
                    }
                    else {
                        right = mid - 1;
                    }
                }
            }
        }

        return -1;
    }

}
