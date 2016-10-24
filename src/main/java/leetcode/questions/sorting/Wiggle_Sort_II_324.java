package leetcode.questions.sorting;

/**
 Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

 Example:
 (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
 (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

 Note:
 You may assume all input has valid answer.

 Follow Up:
 Can you do it in O(n) time and/or in-place with O(1) extra space?

 ----------------------------------------------------------------------------------------------------

 Seems like if i sort it in order and then just interweave them starting from middle?

 1) 1, 5, 1, 1, 6, 4 -> 1, 1, 1, 4, 5, 6 -> 1, 4, 1, 5, 1, 6
 2) 1, 3, 2, 2, 3, 1 -> 1, 1, 2, 2, 3, 3 -> 1, 2, 1, 3, 2, 3

 Ah lol O(nlogn) and O(n) space

 The answer is kinda crazy. First you need to find the median (kth largest) and then do dutch flag sort...and then
 swap various indexes to make it wiggle

 13   6   5   5   4   2

          M

 (1) elements smaller than the 'median' are put into the last even slots
 (2) elements larger than the 'median' are put into the first odd slots
 (3) the medians are put into the remaining slots.
 Index :       0   1   2   3   4   5
 Small half:   M       S       S
 Large half:       L       L       M


 */
public class Wiggle_Sort_II_324 {

    public static void wiggleSort(int[] nums) {
        if ((nums == null) || (nums.length < 2)) {
            return;
        }

        int median = findKthLargest(nums, 0, nums.length - 1, nums.length >> 1);

        int n = nums.length;

        int left = 0, i = 0, right = n - 1;

        while (i <= right) {
            if (nums[newIndex(i,n)] > median) {
                swap(nums, newIndex(left++,n), newIndex(i++,n));
            }
            else if (nums[newIndex(i,n)] < median) {
                swap(nums, newIndex(right--,n), newIndex(i,n));
            }
            else {
                i++;
            }
        }
    }

    private static int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }

    private static int findKthLargest(int[] nums, int left, int right, int kIndex) {
        if ((nums == null) || (nums.length == 0)) {
            return 0;
        }

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
