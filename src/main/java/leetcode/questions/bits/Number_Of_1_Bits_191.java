package leetcode.questions.bits;

/**
 Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

 For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.

 -------------------------------------------------------------------------------------------------------------------

 Simple bitwise and

 */
public class Number_Of_1_Bits_191 {

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int count = 0;

        for (int bits = 0; bits < 32; bits++) {
            // we shift first since we want to ignore the sign
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }

        return count;
    }

}
