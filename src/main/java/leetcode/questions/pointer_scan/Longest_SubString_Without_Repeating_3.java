package leetcode.questions.pointer_scan;

import java.util.HashMap;
import java.util.Map;

/**
 Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 seems like longest palindrome question except the check function is different
 walk through each char left and right and then expand to either side, using something like a map to keep tracking of chars, once existing char is
 encountered on both side, stop expanding and record the length. Now keep tracking for the max length and respective indexes

 O(n^2)

 Now if we say we don't need to parse the same part again, could this be linear....
 like when I encounter a dupe, i can reset the starting point to next char and continue counting
 pw -> wke -> kew

 pwabcwdefgh
 pwabc -> abcwdefgh

 Seems like this is closest to linear, only rescans when we need to remove lookup up the first dupe

 */
public class Longest_SubString_Without_Repeating_3 {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }

        // result to return
        int maxLength = 0;

        int start = 0;
        int index = 0;

        Map<Character, Integer> lookup = new HashMap<>();
        while (index <= s.length()) {
            // i don't want to process the very last bit, we will fake the last char as dupe and process the last bit
            if ((index == s.length()) || (lookup.containsKey(s.charAt(index)))) {
                // dupe found let's cal length
                int length = index - start;
                if (length > maxLength) {
                    // new bigger one found, replace
                    maxLength = length;
                }

                // return value here...so we don't need to bother checking for last value later
                if (index == s.length()) {
                    return maxLength;
                }

                int originalStart = start;
                // replace the start to the next char of first dupe (since what's next up to now is unique, we
                // want to see if this could yield a longer sub string)
                start = lookup.get(s.charAt(index)) + 1;

                // clear dupe check lookup up to this index
                for (int removeIndex = originalStart; removeIndex < start; removeIndex++) {
                    lookup.remove(s.charAt(removeIndex));
                }
            }

            lookup.put(s.charAt(index), index);
            index++;
        }

        // something bad happened
        throw new IllegalStateException();
    }

}
