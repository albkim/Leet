package leetcode.questions.array;

/**
 Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal
 to the product of all the elements of nums except nums[i].

 Solve it without division and in O(n).

 For example, given [1,2,3,4], return [24,12,8,6].

 Follow up:
 Could you solve it with constant space complexity? (Note: The output array does not count as extra space
 for the purpose of space complexity analysis.)

 ---------------------------------------------------------------------------------------------------------

 Not sure about constant space solution but if I can use 2 arrays, I can do running product from either side and multiply

 Constant space is kinda similar. Fill the result array with right to left product. Keep a total product variable. As we
 scan left right. Use it like the two array solution to fill the current cell.

 */
public class Product_Array_Except_Self_238 {

    public static int[] productExceptSelf(int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return new int[]{};
        }

        int total = 1;
        int[] result = new int[nums.length];

        for (int index = nums.length - 1; index >= 1; index--) {
            // current stores product including current
            total *= nums[index];
            result[index] = total;
        }

        // now scan left to right
        total = 1;
        for (int index = 0; index < nums.length; index++) {
            // here don't process current first
            int productRight = (index < nums.length - 1) ? result[index + 1] : 1;
            result[index] = total * productRight;
            total *= nums[index];
        }

        return result;
    }

    public static int[] productExceptSelfTwoArray(int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return new int[] {};
        }

        int[] dpLeft = new int[nums.length];
        int[] dpRight = new int[nums.length];

        dpLeft[0] = nums[0];
        for (int index = 1; index < nums.length - 1; index++) {
            dpLeft[index] = dpLeft[index - 1] * nums[index];
        }

        dpRight[nums.length - 1] = nums[nums.length - 1];
        for (int index = nums.length - 2; index > 0; index--) {
            dpRight[index] = dpRight[index + 1] * nums[index];
        }

        int[] products = new int[nums.length];
        for (int index = 0; index < nums.length; index++) {
            int left = (index > 0) ? dpLeft[index - 1] : 1;
            int right = (index < nums.length - 1) ? dpRight[index + 1] : 1;

            products[index] = left * right;
        }

        return products;
    }

}
