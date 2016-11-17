package leetcode.hard;

import java.util.Stack;

/**
 Given an encoded string, return it's decoded string.

 The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being
 repeated exactly k times. Note that k is guaranteed to be a positive integer.

 You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

 Furthermore, you may assume that the original data does not contain any digits and that digits are only for
 those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 Examples:
 s = "3[a]2[bc]", return "aaabcbc".
 s = "3[a2[c]]", return "accaccacc".
 s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

 ---------------------------------------------------------------------------------------------------------------

 Parse number, when I encounter "[" then push the number to stack, if we encounter "]" then pop the number and repeat
 current pattern n times. If stack is empty, just append to final result

 */
public class Decode_String_394 {

    public static String decodeString(String s) {
        if ((s == null) || (s.length() == 0)) {
            return s;
        }

        StringBuilder result = new StringBuilder();
        StringBuilder number = new StringBuilder();
        Stack<Integer> repeat = new Stack<>();
        Stack<StringBuilder> repeatPattern = new Stack<>();
        for (char chr : s.toCharArray()) {
            if ((chr >= '0') && (chr <= '9')) {
                number.append(chr);
            }
            else if ((chr >= 'a') && (chr <= 'z')) {
                // stack check here
                if (repeat.size() > 0) {
                    repeatPattern.peek().append(chr);
                }
                else {
                    result.append(chr);
                }
            }
            else if (chr == '[') {
                // should be that there should be a number
                repeat.push(Integer.parseInt(number.toString()));
                repeatPattern.push(new StringBuilder());
                number = new StringBuilder();
            }
            else if (chr == ']') {
                int times = repeat.pop();
                String current = repeatPattern.pop().toString();
                for (int count = 0; count < times; count++) {
                    if (repeat.size() > 0) {
                        repeatPattern.peek().append(current);
                    }
                    else {
                        result.append(current);
                    }
                }
            }
        }

        return result.toString();
    }

}
