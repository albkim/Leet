package leetcode.questions.bits;

/**
 Given an array of integers, every element appears three times except for one. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?


 ------------------------------------------------------------------------------------------------------------

 The nice solution is where we count all the bits. If we convert all numbers to bits, each 1's should occurr n times
 If we were to mod total number of 1's by n, it should be 0 if the number contains that bit

 Then we just need to construct the number from these bits

 */
public class Single_Number_II_137 {

    public static int singleNumber(int[] nums) {
        int n = 3;

        int number = 0;

        for (int bit = 0; bit < 32; bit++) {
            int count = 0;
            for (int num : nums) {
                int bitAt = num >> bit;
                if ((bitAt & 1) == 1) {
                    count++;
                }
            }

            if ((count % n) > 0) {
                number |= (1 << bit);
            }
        }

        return number;
    }

}
