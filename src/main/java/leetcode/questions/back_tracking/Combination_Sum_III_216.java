package leetcode.questions.back_tracking;

import java.util.ArrayList;
import java.util.List;

/**

 Find all possible combinations of k numbers that add up to a number n, given that only numbers
 from 1 to 9 can be used and each combination should be a unique set of numbers.

 Example 1:

 Input: k = 3, n = 7

 Output:

 [[1,2,4]]


 Example 2:

 Input: k = 3, n = 9

 Output:

 [[1,2,6], [1,3,5], [2,3,4]]

---------------------------------------------------------------------------------------------------------------

 Seems like similar idea to integer partition, we can be smart about which number to start from

 */
public class Combination_Sum_III_216 {

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();

        if (n - k < 1) {
            return result;
        }

        backtrack(result, new ArrayList<>(), new boolean[10], n, n, k);

        return result;
    }

    private static void backtrack(List<List<Integer>> result, ArrayList<Integer> current, boolean[] used, int max, int n, int k) {
        if ((n == 0) && (k == 0)) {
            result.add(new ArrayList<>(current));
        }
        if (n <= 0) {
            return;
        }

        int maxNumber = Math.min(max, n - factorial(k - 1));
        maxNumber = Math.min(maxNumber, 9);
        for (int number = maxNumber; number > 0; number--) {
            if (used[number]) {
                continue;
            }
            used[number] = true;
            current.add(number);
            backtrack(result, current, used, number - 1, n - number, k - 1);
            current.remove(current.size() - 1);
            used[number] = false;
        }
    }

    private static int factorial(int k) {
        int factorial = 0;
        for (int count = 1; count <= k; count++) {
            factorial += count;
        }
        return factorial;
    }

}
