package leetcode.hard;

import java.util.Stack;

/**
 Implement a basic calculator to evaluate a simple expression string.

 The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

 You may assume that the given expression is always valid.

 Some examples:

 "1 + 1" = 2
 " 2-1 + 2 " = 3
 "(1+(4+5+2)-3)+(6+8)" = 23


 ------------------------------------------------------------------------------------------------------

 We can use a stack to store all elements. Once we encounter a terminal condition (at the end, or ")"), we can pop till
 we get to the previous begin point (empty or "(") and evaluate and push it back in.

 */
public class Basic_Calculator_224 {

    public static int calculate(String s) {
        if ((s == null) || (s.trim().length() == 0)) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int sign = 1;

        for (int index = 0; index < s.length(); index++) {
            char chr = s.charAt(index);
            if (Character.isDigit(chr)) {
                // parse the number out
                int number = chr - '0';
                while ((index + 1 < s.length()) && (Character.isDigit(s.charAt(index + 1)))) {
                    number = number * 10 + (s.charAt(index + 1) - '0');
                    index++;
                }

                // add the number to the result, carefully apply the current sign
                result = result + (sign * number);
            }
            else if (chr == '+') {
                sign = 1;
            }
            else if (chr == '-') {
                sign = -1;
            }
            else if (chr == '(') {
                // at this point, result holds all the sums thus far and there should be a sign
                // xxx +

                stack.push(result);
                stack.push(sign);

                result = 0;
                sign = 1;
            }
            else if (chr == ')') {
                // at this point, stack holds previous sum with sign and result holds current sum inside ()
                result = (/* current sign */ stack.pop() * result) + /* previous sum */ stack.pop();
            }

            // spaces
        }

        return result;
    }

    public static int calculateString(String s) {
        if ((s == null) || (s.trim().length() == 0)) {
            return 0;
        }

        char[] expression = (s + " ").toCharArray();
        Stack<String> stored = new Stack<>();

        StringBuilder number = new StringBuilder();
        for (char chr : expression) {
            if ((chr == ' ') || (chr == '+') || (chr == '-') || (chr == '(') || (chr == ')')) {
                if (number.length() > 0) {
                    stored.push(number.toString());
                    number = new StringBuilder();
                }
            }
            switch(chr) {
                case ' ':
                    break;
                case '+':
                case '-':
                    stored.push(String.valueOf(chr));
                    break;
                case '(':
                    stored.push("(");
                    break;
                case ')':
                    // pop things off till previous "(" and evaluate and put back
                    Stack<String> queue = new Stack<>();
                    while(!stored.empty()) {
                        String token = stored.pop();
                        if (token == "(") {
                            break;
                        }
                        queue.add(token);
                    }
                    stored.push(String.valueOf(evaluate(queue)));
                    break;
                default:
                    number.append(chr);
                    break;
            }
        }

        Stack<String> queue = new Stack<>();
        while(!stored.empty()) {
            queue.add(stored.pop());
        }
        return evaluate(queue);
    }

    private static int evaluate(Stack<String> expression) {
        int answer = 0;

        int sign = 1;
        while(!expression.empty()) {
            String token = expression.pop();
            if (token.equals("+")) {
                sign = 1;
            }
            else if (token.equals("-")) {
                sign = -1;
            }
            else {
                answer += (sign * Integer.parseInt(token));
            }
        }

        return answer;
    }

}
