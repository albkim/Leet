package leetcode.questions.data_structures.map;

import java.util.HashMap;
import java.util.Map;

/**
 Given two strings s and t which consist of only lowercase letters.

 String t is generated by random shuffling string s and then add one more letter at a random position.

 Find the letter that was added in t.

 Example:
 Input:
 s = "abcd"
 t = "abcde"

 Output:
 e

 Explanation:
 'e' is the letter that was added.

-----------------------------------------------------------------------------------------------

 Use map to find the diff

 */
public class Find_Difference_389 {

    public static char findTheDifference(String s, String t) {
        Map<Character, Integer> lookup = new HashMap<>();

        for (char chr : t.toCharArray()) {
            lookup.put(chr, lookup.getOrDefault(chr, 0) + 1);
        }

        for (char chr : s.toCharArray()) {
            int count = lookup.get(chr);
            if (count == 1) {
                lookup.remove(chr);
            }
            else {
                lookup.put(chr, count - 1);
            }
        }

        return lookup.keySet().iterator().next();
    }

}
