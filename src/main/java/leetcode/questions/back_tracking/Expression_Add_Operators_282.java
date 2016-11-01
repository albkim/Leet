package leetcode.questions.back_tracking;

import java.util.ArrayList;
import java.util.List;

/**
 Given a string that contains only digits 0-9 and a target value, return all possibilities
 to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

 Examples:

 "123", 6 -> ["1+2+3", "1*2*3"]
 "232", 8 -> ["2*3+2", "2+3*2"]
 "105", 5 -> ["1*0+5","10-5"]
 "00", 0 -> ["0+0", "0-0", "0*0"]
 "3456237490", 9191 -> []

 --------------------------------------------------------------------------------------------------

 We can try various operators and see if it equals the target. If so then add it to the result.
 If we didn't have "*" and "" which changes the order of execution this would be easy...we can pass the result
 to next iteration.

 Handle "" by enumerating number of all length
 Handle "*" by passing the current additional value (-value if subtraction). Then the current answer to be passed is
    answer - previous + (previous * number), then previous * number as current value
 */
public class Expression_Add_Operators_282 {

    public static List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();

        if ((num == null) || (num.length() == 0)) {
            return result;
        }

        backtrack(result, new StringBuilder(), num, target, 0, 0, 0);

        return result;
    }

    private static void backtrack(List<String> result, StringBuilder expression, String num, int target, long answer, long previous, int start) {
        if (start == num.length()) {
            if (target == answer) {
                // we got an answer
                result.add(expression.toString());
            }
            return;
        }

        // we need to consider 2 cases
        //  concatenation of numbers
        //  operators (+, -, *)
        for (int index = start; index < num.length(); index++) {
            String numberString = num.substring(start, index + 1);
            long number = Long.parseLong(num.substring(start, index + 1));

            // we don't want to allow numbers starting with 0;
            if ((num.charAt(start) == '0') && (index > start)) {
                return;
            }

            if (start == 0) {
                // starting the expression no operators at this point
                expression.append(number);
                backtrack(result, expression, num, target, number, number, index + 1);
                expression.delete(start, index + 1);
            }
            else {
                int previousIndex = expression.length();
                // +
                expression.append('+');
                expression.append(number);
                backtrack(result, expression, num, target, answer + number, number, index + 1);
                expression.delete(previousIndex, previousIndex + numberString.length() + 1);

                // -
                expression.append('-');
                expression.append(number);
                backtrack(result, expression, num, target, answer - number, -1 * number, index + 1);
                expression.delete(previousIndex, previousIndex + numberString.length() + 1);

                // *
                // some special handling since * has to be evaluated first. subtract previous from answer and then
                // multiply
                expression.append('*');
                expression.append(number);
                backtrack(result, expression, num, target, answer - previous + (previous * number), previous * number, index + 1);
                expression.delete(previousIndex, previousIndex + numberString.length() + 1);
            }
        }
    }

}
