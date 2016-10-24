package leetcode.questions.binary_search;

/**
 Given an unsorted array of integers, find the length of longest increasing subsequence.

 For example,
 Given [10, 9, 2, 5, 3, 7, 101, 18],
 The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
 Note that there may be more than one LIS combination, it is only necessary for you to return the length.

 Your algorithm should run in O(n2) complexity.

 Follow up: Could you improve it to O(n log n) time complexity?

 -----------------------------------------------------------------------------------------------------------

 this is the binary search method....if the number is larger, add, otherwise find a place to replace (largest number)

 10 -> 9 -> 2 -> 3
 2, 5
 2, 5, 7
 2, 5, 7, 101 -> 18

 */
public class Longest_Increasing_Subsequence_300 {

    public static int lengthOfLIS(int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return 0;
        }

        int[] a = new int[nums.length];
        a[0] = nums[0];

        int tip = 0;

        for (int index = 1; index < nums.length; index++) {
            int num = nums[index];
            if (num > a[tip]) {
                tip++;
                a[tip] = num;
                continue;
            }
            else {
                int left = 0;
                int right = tip;
                int maxIndex = tip;
                while(left <= right) {
                    int mid = left + ((right - left) >> 1);
                    if (a[mid] >= num) {
                        // move right
                        maxIndex = Math.min(maxIndex, mid);
                        right = mid - 1;
                    }
                    else {
                        // move left and keep the index
                        left = mid + 1;
                    }
                }
                a[maxIndex] = num;
            }
        }

        return tip + 1;
    }

}
