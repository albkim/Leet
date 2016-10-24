package leetcode.questions.dp;

/**
 Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.


 -----------------------------------------------------------------------------------------


 Kadane's method
 Negative handling is the key
 */
public class Maximum_Subarray_53 {

    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int number : nums) {
            sum = Math.max(sum + number, number);
            max = Math.max(max, sum);
        }

        return max;
    }

}
