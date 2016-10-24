package leetcode.questions.binary_search;

/**
 *
 Given a positive integer num, write a function which returns True if num is a perfect square else False.
 Note: Do not use any built-in library function such as sqrt.
 Example 1:
 Input: 16
 Returns: True

 Example 2:
 Input: 14
 Returns: False

 This is very similar to doing sqrt using binary search/newton's method
 */
public class Valid_Perfect_Square_367 {

    public static boolean isPerfectSquare(int num) {
        // do binary search where search condition is n*n = num
        if (num <= 0) {
            return false;
        }

        int start = 1;
        int end = num;

        while (start <= end) {
            long mid = start + ((end - start) >> 2);
            long product = mid * mid;
            if (product == num) {
                return true;
            }
            else if (product < num) {
                start = (int)mid + 1;
            }
            else {
                end = (int)mid - 1;
            }
        }

        return false;
    }

}
