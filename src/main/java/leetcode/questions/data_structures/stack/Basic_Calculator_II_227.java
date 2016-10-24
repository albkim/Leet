package leetcode.questions.data_structures.stack;

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
