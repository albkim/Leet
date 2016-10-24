package leetcode.questions.number;

/**
 Determine whether an integer is a palindrome. Do this without extra space

 Could negative integers be palindromes? (ie, -1)

 If you are thinking of converting the integer to string, note the restriction of using extra space.

 You could also try reversing an integer. However, if you have solved the problem "Reverse Integer",
 you know that the reversed integer might overflow. How would you handle such case?

 There is a more generic way of solving this problem.


 Seems like I need to look at the left and right by dividing
 */
public class Palindrome_Number_9 {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        // always true if only single char
        if (x < 10) {
            return true;
        }

        // left side will start from the highest digit
        // log10 of 10 = 1, 100 = 2, 1000 = 3, 10000 = 4
        int leftFactor = (int)Math.floor(Math.log10(x));

        for(int factor = leftFactor; factor >= 0; factor -= 2) {
            int left = x / (int)Math.pow(10, factor);
            int right = x % 10;

            if (left != right) {
                return false;
            }

            // remove left and right
            x = (x - (left * (int)Math.pow(10, factor))) / 10;
        }

        return true;
    }

}
