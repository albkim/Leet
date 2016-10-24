package leetcode.questions.string;

import java.util.HashMap;
import java.util.Map;

/**
 Given two strings s and t, determine if they are isomorphic.

 Two strings are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character while preserving the order of characters.
 No two characters may map to the same character but a character may map to itself.

 For example,
 Given "egg", "add", return true.

 Given "foo", "bar", return false.

 Given "paper", "title", return true.

 Note:
 You may assume both s and t have the same length.

 --------------------------------------------------------------------------------------------------------

 Be optimistic and if I see a character for first time, add it to the mapping. If I see a character the second time,
 see if it matches original mapping.

 */
public class Isomorphic_Strings_205 {

    public static boolean isIsomorphic(String s, String t) {
        if ((s == null) || (t == null) || (s.length() != t.length())) {
            return false;
        }

        if (s.length() == 0) {
            return true;
        }

        Map<Character, Character> maps = new HashMap<>();
        Map<Character, Character> mapt = new HashMap<>();

        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();

        for (int index = 0; index < sa.length; index++) {
            if (maps.containsKey(sa[index])) {
                if (maps.get(sa[index]) != ta[index]) {
                    return false;
                }
            }
            else {
                maps.put(sa[index], ta[index]);
            }
            if (mapt.containsKey(ta[index])) {
                if (mapt.get(ta[index]) != sa[index]) {
                    return false;
                }
            }
            else {
                mapt.put(ta[index], sa[index]);
            }
        }

        return true;
    }

}
