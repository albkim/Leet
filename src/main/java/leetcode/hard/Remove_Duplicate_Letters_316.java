package leetcode.hard;

import java.util.*;

/**
 Given a string which contains only lowercase letters, remove duplicate letters so that every letter
 appear once and only once. You must make sure your result is the smallest in lexicographical order
 among all possible results.

 Example:

 Given "bcabc"
 Return "abc"

 Given "cbacdcbc"
 Return "acdb"

 --------------------------------------------------------------------------------------------------------

 Really helps to know some hints. In this case it is to use stack. What if

    we queue a letter, once we hit a letter which is in front of the letter at the root of the stack we pop off
        b, c -> a then -> a -> a,b,c

    ah it breaks on the second example, we cannot just pop everything off (since there is only 1 d, it's not right)
    maybe scan the string once and remember which has dupes and which does not. We can store the last index.

        c -> b -> a -> a,c -> a,c,d -> ac

    Now try
        c -> b -> a -> a,c -> a,c,d -> (c is used so drop it) -> a,c,d,b (no more b, we need to put it in) -> (drop c again)
 */
public class Remove_Duplicate_Letters_316 {

    public static String removeDuplicateLetters(String s) {
        if ((s == null) || (s.length() == 0)) {
            return s;
        }

        Map<Character, Integer> lookup = new HashMap<>();
        for (int index = 0; index < s.length(); index++) {
            lookup.put(s.charAt(index), index);
        }

        Set<Character> used = new HashSet<>();
        Stack<Character> current = new Stack<>();
        for (int index = 0; index < s.length(); index++) {
            char chr = s.charAt(index);
            while(!current.isEmpty()) {
                if (used.contains(chr)) {
                    break;
                }

                if (current.peek() < chr) {
                    // it's good to try adding this one
                    current.push(chr);
                    used.add(chr);
                    break;
                }
                else if (current.peek() == chr) {
                    break;
                }
                else {
                    // root is behind, see if it can be dropped
                    if (lookup.get(current.peek()) > index) {
                        // there is a possibility of better combination, let's try that
                        char root = current.pop();
                        used.remove(root);
                    }
                    else {
                        break;
                    }
                }
            }

            if (!used.contains(chr)) {
                current.push(chr);
                used.add(chr);
            }
        }

        // now stack should be nice
        StringBuilder result = new StringBuilder();
        while(!current.isEmpty()) {
            result.insert(0, current.pop());
        }
        return result.toString();
    }

}
