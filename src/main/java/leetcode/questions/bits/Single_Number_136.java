package leetcode.questions.bits;

/**
 Given an array of integers, every element appears twice except for one. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 --------------------------------------------------------------------------------------------------------

 If I was to xor everything. Shouldn't it be left with the 1 number?

 */
public class Single_Number_136 {

    public static int singleNumber(int[] nums) {
        int number = 0;

        for(int num : nums) {
            number ^= num;
        }

        return number;
    }

}
