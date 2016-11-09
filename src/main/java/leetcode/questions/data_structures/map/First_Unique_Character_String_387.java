package leetcode.questions.data_structures.map;

import java.util.HashMap;
import java.util.Map;

/**
 Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

 Examples:
 s = "leetcode"
 return 0.

 s = "loveleetcode",
 return 2.



 Note: You may assume the string contain only lowercase letters.

 -------------------------------------------------------------------------------------------------------

 Use a map to keep track of indexes, if i see the char again, set it to -1 or something. Then scan again to find min index
 2n?


 */
public class First_Unique_Character_String_387 {

    public static int firstUniqChar(String s) {
        Map<Character, Integer> lookup = new HashMap<>();

        for (int index = 0; index < s.length(); index++) {
            char chr = s.charAt(index);
            if (lookup.containsKey(chr)) {
                lookup.put(chr, -1);
            }
            else {
                lookup.put(chr, index);
            }
        }

        int minIndex = Integer.MAX_VALUE;
        for (int index : lookup.values()) {
            if (index > -1) {
                minIndex = Math.min(minIndex, index);
            }
        }

        return minIndex == Integer.MAX_VALUE ? -1 : minIndex;
    }

}
