package leetcode.questions.back_tracking;

import java.util.ArrayList;
import java.util.List;

/**
 The gray code is a binary numeral system where two successive values differ in only one bit.

 Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

 For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 00 - 0
 01 - 1
 11 - 3
 10 - 2


 Note:
 For a given n, a gray code sequence is not uniquely defined.

 For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

 For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.


 -------------------------------------------------------------------------------------------------------------------

 This seems very similar to permutation...the tricky part is that permutation has to happen via 1 bit

 000 -> 001 -> 011 -> 010 -> 110 -> 111 -> 101 -> 100

 */
public class Gray_Code_89 {

    public static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();

        backtrack(result, new ArrayList<>(), new boolean[n], n);

        return result;
    }

    private static void backtrack(List<Integer> result, ArrayList<Boolean> bits, boolean[] last, int n) {
        if (bits.size() == n) {
            // convert bits array into an integer and add result
            int number = 0;
            for (int index = bits.size() - 1; index >= 0; index--) {
                last[index] = bits.get(index);
                if (bits.get(index)) {
                    int pow = bits.size() - 1 - index;
                    number += (int)Math.pow(2, pow);
                }
            }
            result.add(number);
            return;
        }

        // seems like the logic for shift one bit is to see if I've already shifted one bit from the last result
        // this only needs to happen if this is beginning of the permutation
        boolean bitFlipped = false;
        for (int index = 0; index < bits.size(); index++) {
            if (bits.get(index) != last[index]) {
                bitFlipped = true;
                break;
            }
        }
        boolean start = bitFlipped ? last[bits.size()] : false;
        for (int bit = 0; bit <= 1; bit++) {
            bits.add(bit == 0 ? start : !start);
            backtrack(result, bits, last, n);
            bits.remove(bits.size() - 1);
        }
    }

}
