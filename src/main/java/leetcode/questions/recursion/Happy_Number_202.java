package leetcode.questions.recursion;

import java.util.HashSet;
import java.util.Set;

/**
 Write an algorithm to determine if a number is "happy".

 A happy number is a number defined by the following process: Starting with any positive integer,
 replace the number by the sum of the squares of its digits, and repeat the process until the number
 equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 Those numbers for which this process ends in 1 are happy numbers.

 Example: 19 is a happy number
 1^2 + 9^2 = 82
 8^2 + 2^2 = 68
 6^2 + 8^2 = 100
 1^2 + 0^2 + 0^2 = 1

 -------------------------------------------------------------------------------------------------

 I guess the trick here is to determine if there is a cycle...simple

 */
public class Happy_Number_202 {

    public static boolean isHappy(int n) {
        Set<Integer> tried = new HashSet<>();

        return recurse(tried, n);
    }

    private static boolean recurse(Set<Integer> tried, int n) {
        if (tried.contains(n)) {
            return false;
        }

        tried.add(n);

        int sqNum = 0;
        while(n > 0) {
            sqNum += Math.pow(n % 10, 2);
            n /= 10;
        }

        if (sqNum == 1) {
            return true;
        }
        return recurse(tried, sqNum);
    }

}
