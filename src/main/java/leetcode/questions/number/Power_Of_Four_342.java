package leetcode.questions.number;

/**
 Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

 Example:
 Given num = 16, return true. Given num = 5, return false.

 Follow up: Could you solve it without loops/recursion?

 ---------------------------------------------------------------------------------------------

 Too bad know the answer, sqrt and divide 2^31 by the number and check mod
 */
public class Power_Of_Four_342 {

    public boolean isPowerOfFour(int num) {
        return num > 0 && Math.pow(2, 31) % Math.sqrt(num) == 0;
    }

}
