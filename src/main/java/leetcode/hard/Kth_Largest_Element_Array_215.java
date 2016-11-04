package leetcode.hard;

/**
 Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

 For example,
 Given [3,2,1,5,6,4] and k = 2, return 5.

 Note:
 You may assume k is always valid, 1 ? k ? array's length.

 -----------------------------------------------------------------------------------------------

 Quicksort, if pivot index == k, return it

 */
public class Kth_Largest_Element_Array_215 {

    public static int findKthLargest(int[] nums, int k) {
        if ((nums == null) || (nums.length == 0)) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        int kIndex = nums.length - k;
        while(left <= right) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex == kIndex) {
                return nums[pivotIndex];
            }
            else if (kIndex < pivotIndex) {
                // move left
                right = pivotIndex - 1;
            }
            else {
                left = pivotIndex + 1;
            }
        }
        return -1;
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int newLeft = left + 1;
        int newRight = right;

        while(true) {
            while ((newLeft < right) && (nums[newLeft] <= pivot)) newLeft++;
            while ((newRight > left) && (nums[newRight] > pivot)) newRight--;

            if (newLeft >= newRight) {
                break;
            }
            swap(nums, newLeft, newRight);
        }

        swap(nums, left, newRight);

        return newRight;
    }


    private static void swap(int[] nums, int left, int right) {
        int tmp = nums[right];
        nums[right] = nums[left];
        nums[left] = tmp;
    }

}
