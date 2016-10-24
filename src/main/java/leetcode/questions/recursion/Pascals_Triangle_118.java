package leetcode.questions.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 Given numRows, generate the first numRows of Pascal's triangle.

 For example, given numRows = 5,
 Return
 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]

--------------------------------------------------------------------------------------------

 Seems like a simple recursion


 */
public class Pascals_Triangle_118 {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }

        result.add(Collections.singletonList(1));

        recurse(result, numRows, 1);

        return result;
    }

    private static void recurse(List<List<Integer>> result, int numRows, int i) {
        if (numRows == i) {
            return;
        }

        // always add 1
        List<Integer> current = new ArrayList<>();
        current.add(1);

        // now take the last and scan by 2;
        List<Integer> last = result.get(result.size() - 1);
        for (int index = 0; index < last.size() - 1; index++) {
            int left = last.get(index);
            int right = last.get(index + 1);

            current.add(left + right);
        }

        // always add 1;
        current.add(1);
        result.add(current);

        recurse(result, numRows, i + 1);
    }

}
