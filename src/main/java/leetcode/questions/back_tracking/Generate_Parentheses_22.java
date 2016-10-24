package leetcode.questions.back_tracking;

import java.util.ArrayList;
import java.util.List;

/**
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:
 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]

 ()
 (()) ()()
 ((())), (()()), (())(), (())(), ()(()), ()()()


 -----------------------------------------------------------------------------------------------------------


 all permutation algorithm leads to dupes...so need something better
 What if we generate permutation left and right and just have a way to track whether a pattern is valid

 Some rules
    once I have (, I can have ( or ) as long as I don't have more ) than (. Having more ) will create invalid pattern
 */
public class Generate_Parentheses_22 {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(result, "(", 1, 0, n);
        return result;
    }

    private static void generateParenthesis(List<String> result, String pattern, int open, int close, int n) {
        if ((open == n) && (close == n)) {
            result.add(pattern);
            return;
        }

        if (open < n) {
            generateParenthesis(result, pattern + "(", open + 1, close, n);
        }
        if ((close < n) && (open > close)) {
            generateParenthesis(result, pattern + ")", open, close + 1, n);
        }
    }

}
