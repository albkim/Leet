package leetcode.hard;

import java.util.*;

/**
 Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

 Note: The input string may contain letters other than the parentheses ( and ).

 Examples:

 "()())()" -> ["()()()", "(())()"]
 "(a)())()" -> ["(a)()()", "(a())()"]
 ")(" -> [""]

---------------------------------------------------------------------------------------------------------------------

 THe naive solutions seems like removing 1 or more parens until we find a valid combination. Similar to BFS.

 */
public class Remove_Invalid_Parentheses_301 {

    public static List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if ((s == null) || (s.length() == 0)) {
            return Arrays.asList("");
        }

        if (isValid(s)) {
            return Arrays.asList(s);
        }

        Set<String> tried = new HashSet<>();
        Queue<String> current = new ArrayDeque<>();
        Queue<String> next = new ArrayDeque<>();
        current.add(s);

        while(!current.isEmpty()) {
            String pattern = current.poll();
            for (int index = 0; index < pattern.length(); index++) {
                char chr = pattern.charAt(index);
                if ((chr != '(') && (chr != ')')) {
                    continue;
                }
                // remove one
                String newPattrn = pattern.substring(0, index) + pattern.substring(index + 1);
                if (tried.contains(newPattrn)) {
                    continue;
                }
                if (isValid(newPattrn)) {
                    result.add(newPattrn);
                }
                else {
                    // if we already found a valid one, no need to add the new one
                    next.add(newPattrn);
                }
                tried.add(newPattrn);
            }
            if (current.isEmpty()) {
                if (result.size() > 0) {
                    return result;
                }
                current = next;
                next = new ArrayDeque<>();
            }
        }

        return result;
    }

    private static boolean isValid(String pattern) {
        Stack<Character> stack = new Stack<>();
        for (char chr : pattern.toCharArray()) {
            if (chr == '(') {
                stack.push('(');
            }
            else if (chr == ')') {
                if (stack.empty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.size() == 0;
    }

}
