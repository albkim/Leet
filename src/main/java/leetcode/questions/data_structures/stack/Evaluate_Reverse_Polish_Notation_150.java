package leetcode.questions.data_structures.stack;

import java.util.Stack;

/**
 Evaluate the value of an arithmetic expression in Reverse Polish Notation.

 Valid operators are +, -, *, /. Each operand may be an integer or another expression.

 Some examples:

 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6


 Reverse Polish notation (RPN) is a mathematical notation in which every operator follows all of its operands

 ----------------------------------------------------------------------------

 Seems like a simple stack question?

 when we encounter a none operator, push into stack. Once we encounter a operator, pop 2 from stack and evaluate
 The key is then to push the intermediate result back into stack for further evaluation. Once we reach the end
 We should only have 1 item in the stack which is the result

 */
public class Evaluate_Reverse_Polish_Notation_150 {

    public static int evalRPN(String[] tokens) {
        if (tokens == null) {
            return 0;
        }

        // looks like the correct behavior in one number is to return the number
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }

        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            }
            else if (token.equals("-")) {
                int after = stack.pop();
                int before = stack.pop();
                stack.push(before - after);
            }
            else if (token.equals("/")) {
                int after = stack.pop();
                int before = stack.pop();
                stack.push(before / after);
            }
            else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            }
            else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

}
