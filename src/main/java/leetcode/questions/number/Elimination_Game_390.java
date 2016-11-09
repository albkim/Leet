package leetcode.questions.number;

/**
 There is a list of sorted integers from 1 to n. Starting from left to right, remove the first number and
 every other number afterward until you reach the end of the list.

 Repeat the previous step again, but this time from right to left, remove the right most number
 and every other number from the remaining numbers.

 We keep repeating the steps again, alternating left to right and right to left, until a single number remains.

 Find the last number that remains starting with a list of length n.

 Example:
 Input:
 n = 9,
 1 2 3 4 5 6 7 8 9
 2 4 6 8
 2 6
 6

 Output:
 6

 ----------------------------------------------------------------------------------------------------

 Not sure who'd ask question like this but it seems like when the first element changes, we want to keep track of it
 until there is just 1 item

 when we move left to right, always move it to next one and total # is cut in half
 not when we move right to left, there are two cases
    if total # is odd, it changes the first element
        2 4 6 8 10 -> 4, 8
    if total # is even, there is no change
        2 4 6 8 -> 2 6

 Since we remove half each time, looks like head/next number jumps by 2x every iteration...

 */
public class Elimination_Game_390 {

    public static int lastRemaining(int n) {
        int total = n;
        int head = 1;
        int step = 1;
        boolean moveLeftToRight = true;

        while(total > 1) {
            if ((moveLeftToRight) || (total % 2 == 1)) {
                head = head + step;
            }
            step *= 2;
            total /= 2;
            moveLeftToRight = !moveLeftToRight;
        }

        return head;
    }

}
