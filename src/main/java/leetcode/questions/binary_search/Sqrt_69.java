package leetcode.questions.binary_search;

/**
 Implement int sqrt(int x).

 Compute and return the square root of x.


 -----------------------------------------------------------------------------------------------------------

 Simple binary search...we can even derive newton's method from refactoring mid
 */
public class Sqrt_69 {

    public static int mySqrt(int x) {
        if (x < 1) {
            return 0;
        }

        int start = 1;
        int end = x;

        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            long sq = (long)mid * (long)mid;
            if (sq == x) {
                return mid;
            }
            else if (sq < x) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return end;
    }

}
