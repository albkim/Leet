package leetcode.questions.data_structures.stack;

import java.util.Stack;

/**
 Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

 */
public class Valid_Parentheses_20 {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char chr : s.toCharArray()) {
            if ((chr == '(') || (chr == '{') || (chr == '[')) {
                stack.push(chr);
            }
            else
            {
                if (stack.empty()) {
                    return false;
                }

                char existing = stack.pop();
                if ((existing == '(') && ((chr == '}') || (chr == ']'))) {
                    return false;
                }
                if ((existing == '[') && ((chr == ')') || (chr == '}'))) {
                    return false;
                }
                if ((existing == '{') && ((chr == ')') || (chr == ']'))) {
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }

}
