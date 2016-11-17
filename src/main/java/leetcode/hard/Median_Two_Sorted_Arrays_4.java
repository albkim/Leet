package leetcode.hard;

/*

 There are two sorted array nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted array. The overall run time complexity should be O(log (m+n)).

 Example 1:

 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0



 Example 2:

 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5

 The complexity pretty much suggest a binary search. Looks like the condition needs to be different.

 */
public class Median_Two_Sorted_Arrays_4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1 == null) || (nums2 == null)) {
            throw new IllegalArgumentException();
        }

        int total = nums1.length + nums2.length;
        int k = total / 2;

        // if total is even (e.g. 4) then we need to take avg of two mid number
        if ((total % 2) == 0) {
            return (findKth(nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1, k)
                    + findKth(nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1, k + 1)) / 2d;
        }
        else {
            return findKth(nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1, k + 1);
        }
    }

    public static int findKth(int[] nums1, int[] nums2, int start1, int end1, int start2, int end2, int k) {
        // input check
        if (((end1 - start1 + 1) + (end2 - start2 + 1)) < k) {
            throw new IllegalArgumentException();
        }

        // special case...if we exhaust one of the array completely, it's now very easy, search the other one for kth
        if (start1 > end1) {
            return nums2[start2 + k - 1];
        }
        if (start2 > end2) {
            return nums1[start1 + k - 1];
        }

        // now pick i & j. Since we are here we know relationship of k - 1 = i + j should be true if we
        // take the smaller array and take the min of the length or k/2 position

        // by targeting k - i - 1, we are trying to k+1 value from the other array so we can use it for
        // boundary check j - 1 < i < j
        int i = 0;
        int j = 0;
        if ((end1 - start1) > (end2 - start2)) {
            j = Math.min(end2, start2 + (k/2));
            i = k - (j - start2) - 1 + start1;
        }
        else {
            i = Math.min(end1, start1 + (k/2));
            j = k - (i - start1) - 1 + start2;
        }

        // now if ai-1 < bj < ai then bj has to k by definition
        // same the other way
        int ai_1 = (i > start1) ? nums1[i - 1] : Integer.MIN_VALUE;
        int bj_1 = (j > start2) ? nums2[j - 1] : Integer.MIN_VALUE;
        int ai = (i > end1) ? Integer.MAX_VALUE : nums1[i];
        int bj = (j > end2) ? Integer.MAX_VALUE : nums2[j];

        if ((bj_1 <= ai) && (ai <= bj)) {
            return ai;
        }
        if ((ai_1 <= bj) && (bj <= ai)) {
            return bj;
        }

        // now if ai < bj then ai < bj_1...since above was not true, that mean we want to eliminate up to ai and above bj
        if (ai < bj) {
            return findKth(nums1, nums2, i + 1, end1, start2, j - 1, k - (i - start1) - 1);
        }
        else {
            return findKth(nums1, nums2, start1, i - 1, j + 1, end2, k - (j - start2) - 1);
        }
    }

}

