package leetcode.questions.binary_search;

/**

 I pick a number from 1 to n. You have to guess which number I picked.
 Every time you guess wrong, I'll tell you whether the number is higher or lower.
 You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 -1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
 Example: 
 n = 10, I pick 6.

 Return 6.

 */
public class Number_Higher_Lower_374 {

    private final int number;

    public Number_Higher_Lower_374(int number) {
        this.number = number;
    }

    private int guess(int num) {
        if (num == this.number) {
            return 0;
        }
        else if (num < this.number) {
            return 1;
        }
        else {
            return -1;
        }
    }

    /* The guess API is defined in the parent class GuessGame.
       @param num, your guess
       @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
          int guess(int num); */
    public int guessNumber(int n) {
        int start = 1;
        int end = n;

        // binary search?
        while(start <= end) {
            int mid = start + ((end - start) >> 2);

            int answer = guess(mid);
            if (answer == 0) {
                return mid;
            }
            else if (answer == 1) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        // not found?
        throw new IllegalStateException();
    }

}
