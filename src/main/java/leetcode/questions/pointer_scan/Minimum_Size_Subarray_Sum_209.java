package leetcode.questions.pointer_scan;

/**
 Given an array of n positive integers and a positive integer s, find the minimal length of a
 subarray of which the sum ? s. If there isn't one, return 0 instead.

 For example, given the array [2,3,1,2,4,3] and s = 7,
 the subarray [4,3] has the minimal length under the problem constraint.

 -----------------------------------------------------------------------------------------

 This looks like a running sum type question. Since it's all positive, I can scan right until I get or over the sum.
 Then as I scan right more, I can move my left until it's at or over sum and keep the min length

 */
public class Minimum_Size_Subarray_Sum_209 {

    public static int minSubArrayLen(int s, int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return 0;
        }

        int right = 0;
        int left = 0;
        int sum = 0;
        int length = Integer.MAX_VALUE;

        while(right < nums.length) {
            sum += nums[right++];
            while (sum >= s) {
                length = Math.min(length, right - left);
                sum -= nums[left++];
            }
        }

        return (length == Integer.MAX_VALUE) ? 0 : length;
    }

}
