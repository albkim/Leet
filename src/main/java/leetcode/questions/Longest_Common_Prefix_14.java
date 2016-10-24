package leetcode.questions;

/**
 Write a function to find the longest common prefix string amongst an array of strings.

 I am guessing the prefix means it has to start from index 0 and this is similar to merge sort
 */
public class Longest_Common_Prefix_14 {

    public static String longestCommonPrefix(String[] strs) {
        if ((strs == null) || (strs.length == 0)) {
            return "";
        }

        String one = strs[0];

        for (int index = 0; index < one.length(); index++) {
            char chr = one.charAt(index);
            for(String str : strs) {
                if ((index >= str.length()) || (str.charAt(index) != chr)) {
                    return one.substring(0, index);
                }
            }
        }

        return one;
    }

}
