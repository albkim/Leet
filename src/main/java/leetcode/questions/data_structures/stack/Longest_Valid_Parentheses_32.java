package leetcode.questions.data_structures.stack;

import java.util.Stack;

/**
 Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 For "(()", the longest valid parentheses substring is "()", which has length = 2.

 Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

 Several cases
 1. ()()
 2. (()())
 3. (((()
 4. ())))
 5. ())))()()

 As with typical paren questions, seems like we need to use stack
 In order to handle case 2 (where a bigger paren could contain small successful patterns (no longer in stack), we could store index
 */
public class Longest_Valid_Parentheses_32 {

    public static int longestValidParentheses(String s) {
        int left = -1;
        int maxLength = 0;
        Stack<Integer> stack = new Stack<>();
        for (int index = 0; index < s.length(); index++) {
            if (s.charAt(index) == '(') {
                stack.add(index);
            }
            else {
                // case #4...if stack is empty, we have extra ), this could never be a continuous pattern
                if (stack.empty()) {
                    left = index;
                }
                else {
                    // we got a pair
                    stack.pop();
                    // check if this is end. like case 1,2
                    if (stack.empty()) {
                        maxLength = Math.max(maxLength, index - left);
                    }
                    else {
                        // case #3...there are more open then close
                        // we cannot use left since it will be at the beginning of open
                        // use the next stack as left boundary
                        maxLength = Math.max(maxLength, index - stack.peek());
                    }
                }
            }
        }
        return maxLength;
    }

}
