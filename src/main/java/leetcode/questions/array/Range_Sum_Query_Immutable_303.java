package leetcode.questions.array;

/**
 Given an integer array nums, find the sum of the elements between indices i and j (i ? j), inclusive.

 Example:

 Given nums = [-2, 0, 3, -5, 2, -1]

 sumRange(0, 2) -> 1
 sumRange(2, 5) -> -1
 sumRange(0, 5) -> -3

 Note:

 1.You may assume that the array does not change.
 2.There are many calls to sumRange function.

 ----------------------------------------------------------------------------------------------------------

 Keep a running sum and we just need to do some nice subtraction

 -2, -2, 1, -4, -2, -3

 */
public class Range_Sum_Query_Immutable_303 {

    private int[] sums;

    public Range_Sum_Query_Immutable_303(int[] nums) {
        this.sums = new int[nums.length];

        for (int index = 0; index < nums.length; index++) {
            int previous = (index > 0) ? this.sums[index - 1] : 0;
            this.sums[index] = previous + nums[index];
        }
    }

    public int sumRange(int i, int j) {
        int previous = (i > 0) ? sums[i - 1] : 0;
        return sums[j] - previous;
    }

}
