package leetcode.questions.bits;

/**
 Reverse bits of a given 32 bits unsigned integer.

 For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
 return 964176192 (represented in binary as 00111001011110000010100101000000).

 Follow up:
 If this function is called many times, how would you optimize it?

 -----------------------------------------------------------------------------------------------------

 if I can create an array of booleans (32) from the number I can reverse it and create a number by adding bits

 or I just perform the reverse shift...lol

 */
public class Reverse_Bits_190 {

    public static int reverseBits(int n) {
        int newNumber = 0;

        for (int count = 0; count < 32; count++) {
            // we shift first since we want to ignore the sign
            newNumber <<= 1;
            if ((n & 1) == 1) {
                newNumber |= 1;
            }
            n >>= 1;
        }

        return newNumber;
    }

}
