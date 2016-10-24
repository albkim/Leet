package leetcode.questions.number;

/**
 Implement pow(x, n).

 Int is  -2147483648 and 2147483647
 If we can improve this by using n wrt 2, we can improve time complexity

 n = 2 * n/2 + n%2

 pow(x, n) = pow(x, 2 * n/2 + n%2) = pow(x, 2 * n/2) * pow(n%2) = pow(pow(x, n/2), 2) * pow(n%2)

 note the second power can only be 0 or 1 which is it's either 1 or x
 */
public class Pow_X_N_50 {

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            // handle overflow
            return 1 / (x * (myPow(x, -1 * (n + 1))));
        }

        double y = myPow(x, n/2);
        double z = y * y;

        return (n%2 == 0) ? z : (z * x);
    }

}
