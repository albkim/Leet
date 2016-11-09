package leetcode.questions.data_structures.tree;

import java.util.ArrayList;
import java.util.List;

/**
 Given an integer n, return 1 - n in lexicographical order.

 For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].

 Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.

 ------------------------------------------------------------------------------------------------------------

 Seems like the trick is to generate tree's and do pre-order traversal

 e.g.

    1               2
 10 11  12...   20  21  22...
 100....

 */
public class Lexicographical_Numbers_386 {

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }

        for (int number = 1; number < 10; number++) {
            traverse(result, number, n);
        }

        return result;
    }

    private static void traverse(List<Integer> result, int number, int n) {
        if (number > n) {
            return;
        }

        result.add(number);

        number *= 10;
        for (int next = 0; next < 10; next++) {
            traverse(result, number + next, n);
        }
    }

}
