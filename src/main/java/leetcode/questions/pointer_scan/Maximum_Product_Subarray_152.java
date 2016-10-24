package leetcode.questions.pointer_scan;

/**
 Find the contiguous subarray within an array (containing at least one number) which has the largest product.

 For example, given the array [2,3,-2,4],
 the contiguous subarray [2,3] has the largest product = 6.

 ----------------------------------------------------------------------------------------------------------

 This is similar to maximum sum, except handling of negative numbers and 0's

 */
public class Maximum_Product_Subarray_152 {

    public static int maxProduct(int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return 0;
        }

        int max = 1;
        int min = 1;
        int realMax = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num == 0) {
                max = 1;
                min = 1;
                realMax = Math.max(realMax, 0);
            }
            else if (num < 0) {
                boolean alreadyNegative = min < 0;
                int tmp = max;
                max = alreadyNegative ? min * num : 1;
                min = tmp * num;
                realMax = Math.max(realMax, min);
                if (alreadyNegative) {
                    realMax = Math.max(realMax, max);
                }
            }
            else {
                max *= num;
                min = (min < 0) ? min * num : 1;
                realMax = Math.max(realMax, max);
            }
        }

        return realMax;
    }

}
