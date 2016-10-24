package leetcode.questions.binary_search;

/**
 Given a sorted array of integers, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].

 Has to be binary search without iteration. what if i can do two binary search
 go left if equal or smaller and if number is equal, keep track of index
 do same for max
 */
public class Search_For_Range_34 {

    public static int[] searchRange(int[] nums, int target) {
        return new int[] {binarySearch(nums, target, true), binarySearch(nums, target, false)};
    }

    private static int binarySearch(int[] nums, int target, boolean searchMin) {
        int index = - 1;
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + ((right - left) >> 1);

            if (nums[mid] == target) {
                if (searchMin) {
                    if (index == -1) {
                        index = mid;
                    }
                    else {
                        index = Math.min(index, mid);
                    }
                }
                else {
                    index = Math.max(index, mid);
                }
            }
            if (((searchMin) && (nums[mid] == target)) || (nums[mid] > target)) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return index;
    }
}
