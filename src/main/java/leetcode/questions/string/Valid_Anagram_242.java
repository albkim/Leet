package leetcode.questions.string;

import java.util.Arrays;

/**
 Given two strings s and t, write a function to determine if t is an anagram of s.

 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.

 Note:
 You may assume the string contains only lowercase alphabets.

 Follow up:
 What if the inputs contain unicode characters? How would you adapt your solution to such case?

 -----------------------------------------------------------------------------------------------------------

 Sort and compare

 */
public class Valid_Anagram_242 {

    public static boolean isAnagram(String s, String t) {
        if ((s == null) && (t == null)) {
            return true;
        }
        if ((s == null) || (t == null)) {
            return false;
        }

        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();

        if (sa.length != ta.length) {
            return false;
        }

        Arrays.sort(sa);
        Arrays.sort(ta);

        for (int index = 0; index < sa.length; index++) {
            if (sa[index] != ta[index]) {
                return false;
            }
        }

        return true;
    }

}
