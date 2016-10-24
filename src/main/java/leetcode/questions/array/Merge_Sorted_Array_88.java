package leetcode.questions.array;

/**
 Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

 Note:
 You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements
 from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.

 ------------------------------------------------------------------------------------------------------------

 Simple two pointer scan from the right so we can do this in place of num1 since both are sorted.

 */
public class Merge_Sorted_Array_88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int merged = m + n - 1;
        int left = m - 1;
        int right = n - 1;
        while (merged >= 0) {
            if ((left < 0) || ((right >= 0) && (nums1[left] < nums2[right]))) {
                // right is greater
                nums1[merged] = nums2[right];
                right--;
            }
            else {
                nums1[merged] = nums1[left];
                left--;
            }

            merged--;
        }
    }

}
