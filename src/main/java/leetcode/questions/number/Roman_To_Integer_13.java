package leetcode.questions.number;

import java.util.HashMap;
import java.util.Map;

/**
 Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.

 */
public class Roman_To_Integer_13 {

    public static int romanToInt(String s) {
        Map<Character, Integer> lookup = new HashMap<>();
        lookup.put('I', 1);
        lookup.put('V', 5);
        lookup.put('X', 10);
        lookup.put('L', 50);
        lookup.put('C', 100);
        lookup.put('D', 500);
        lookup.put('M', 1000);

        // seems like algo is simple, traverse and look ahead,
        // if next char is equal or smaller, it's add
        // if next char is greater, then we need to subtract current from next (e.g. 4 or 9)
        int number = 0;
        int index = 0;
        while (index < s.length()) {
            char current = s.charAt(index);
            Character next = (index + 1 < s.length()) ? s.charAt(index + 1) : null;
            if ((next != null) && (lookup.get(next) > lookup.get(current))) {
                number += (lookup.get(next) - lookup.get(current));
                index += 2;
            }
            else {
                number += lookup.get(current);
                index++;
            }
        }

        return number;
    }

}
