package leetcode.hard;

import java.util.Stack;

/**
 Implement a basic calculator to evaluate a simple expression string.

 The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
 The integer division should truncate toward zero.

 You may assume that the given expression is always valid.

 Some examples:

 "3+2*2" = 7
 " 3/2 " = 1
 " 3+5 / 2 " = 5

----------------------------------------------------------------------------------------

 Similar to paren, we can pop off the last one and evaluate and put it in. Then it will degrade to sum or substraction

 */
public class Basic_Calculator_II_227 {

    public static int calculate(String s) {
        if ((s == null) || (s.trim().length() == 0)) {
            return 0;
        }

        int sign = 1;
        boolean divide = false;
        Stack<Integer> stack = new Stack<>();

        for (int index = 0; index < s.length(); index++) {
            char chr = s.charAt(index);
            if (Character.isDigit(chr)) {
                int number = chr - '0';
                while ((index + 1 < s.length()) && (Character.isDigit(s.charAt(index + 1)))) {
                    number = (number * 10) + (s.charAt(index + 1) - '0');
                    index++;
                }

                int result = (divide) ? (stack.pop() / number) : (sign * number);
                stack.push(result);
            }
            else if (chr == '+') {
                sign = 1;
                divide = false;
            }
            else if (chr == '-') {
                sign = -1;
                divide = false;
            }
            else if (chr == '*') {
                sign = stack.pop();
                divide = false;
            }
            else if (chr == '/') {
                divide = true;
            }
            // space
        }

        int result = 0;
        while(!stack.isEmpty()) {
            result += stack.pop();
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
            if ((chr == ' ') || (chr == '+') || (chr == '-') || (chr == '*') || (chr == '/')) {
                if (number.length() > 0) {
                    // before we push check the tip and see if this has to be evaluated first
                    if ((!stored.empty()) && ((stored.peek().equals("*")) || (stored.peek().equals("/")))) {
                        // pop 2: one sign and previous number
                        Stack<String> queue = new Stack<>();
                        queue.add(number.toString());
                        queue.add(stored.pop());
                        queue.add(stored.pop());
                        stored.push(String.valueOf(evaluate(queue)));
                    }
                    else{
                        stored.push(number.toString());
                    }
                    number = new StringBuilder();
                }
            }
            switch(chr) {
                case ' ':
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                    stored.push(String.valueOf(chr));
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
        int answer = Integer.MIN_VALUE;

        String operator = null;
        while(!expression.empty()) {
            String token = expression.pop();
            if ((token.equals("+")) || (token.equals("-")) || (token.equals("*")) || (token.equals("/"))) {
                operator = token;
            }
            else {
                int number = Integer.parseInt(token);
                if (answer == Integer.MIN_VALUE) {
                    answer = number;
                }
                else {
                    if (operator.equals("+")) {
                        answer += number;
                    }
                    else if (operator.equals("-")) {
                        answer -= number;
                    }
                    else if (operator.equals("*")) {
                        answer *= number;
                    }
                    else {
                        if (number == 0) {
                            answer = 0;
                        }
                        else {
                            answer /= number;
                        }
                    }
                }
            }
        }

        return answer;
    }
}
