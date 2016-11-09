package leetcode.questions.data_structures.stack;

import leetcode.models.NestedInteger;
import leetcode.models.NestedIntegerImpl;

import java.util.Stack;

/**
 Given a nested list of integers represented as a string, implement a parser to deserialize it.

 Each element is either an integer, or a list -- whose elements may also be integers or other lists.

 Note: You may assume that the string is well-formed:
 •String is non-empty.
 •String does not contain white spaces.
 •String contains only digits 0-9, [, - ,, ].


 Example 1:
 Given s = "324",

 You should return a NestedInteger object which contains a single integer 324.



 Example 2:
 Given s = "[123,[456,[789]]]",

 Return a NestedInteger object containing a nested list with 2 elements:

 1. An integer containing value 123.
 2. A nested list containing two elements:
 i.  An integer containing value 456.
 ii. A nested list with one element:
 a. An integer containing value 789.

-----------------------------------------------------------------------------------------------------

 Seems like this is very close to paren parsing using a stack. When encountering [ , create a nestedinteger list and
 push into stack...then parse all number into it, unless we encounter another [....once we hit ], then pop the current
 list off the stack and continue

 */
public class Mini_Parser_385 {

    public static NestedInteger deserialize(String s) {
        if ((s == null) || (s.length() == 0)) {
            return null;
        }

        NestedInteger result = null;
        Stack<NestedInteger> stack = new Stack<>();

        StringBuilder number = new StringBuilder();
        for (char chr : s.toCharArray()) {
            if (chr == ',') {
                if (number.length() > 0) {
                    stack.peek().add(new NestedIntegerImpl(Integer.parseInt(number.toString())));
                    number = new StringBuilder();
                }
            }
            else if (chr == '[') {
                NestedInteger ni = new NestedIntegerImpl();
                if (stack.size() == 0) {
                    result = ni;
                }
                else {
                    stack.peek().add(ni);
                }
                stack.push(ni);
            }
            else if (chr == ']') {
                if (number.length() > 0) {
                    stack.peek().add(new NestedIntegerImpl(Integer.parseInt(number.toString())));
                    number = new StringBuilder();
                }
                stack.pop();
            }
            else {
                number.append(chr);
            }
        }

        if (number.length() > 0) {NestedInteger ni = new NestedIntegerImpl(Integer.parseInt(number.toString()));
            if (stack.size() == 0) {
                result = ni;
            }
            else {
                stack.peek().add(ni);
            }
        }

        return result;
    }

}
