package leetcode.hard;

import java.util.HashSet;
import java.util.Set;

/**
 Find the length of the longest substring T of a given string (consists of lowercase letters only)
 such that every character in T appears no less than k times.

 Example 1:
 Input:
 s = "aaabb", k = 3

 Output:
 3

 The longest substring is "aaa", as 'a' is repeated 3 times.



 Example 2:
 Input:
 s = "ababbc", k = 2

 Output:
 5

 The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.

 ----------------------------------------------------------------------------------------------------------

 Divide and conquer. We can try to find boundary based on number of occurrence and see if the substring defined
 by these boundaries satisfy the condition (recursively)

 */
public class Longest_Substring_At_Least_K_Repeating_Characters_395 {

    public static int longestSubstring(String s, int k) {
        if ((s == null) || (s.length() == 0)) {
            return 0;
        }

        return recurse(s, k, 0, s.length() - 1);
    }

    private static int recurse(String s, int k, int left, int right) {
        int[] counts = new int[60];
        for (int index = left; index <= right; index++) {
            counts[s.charAt(index) - 'A']++;
        }

        Set<Character> lookup = new HashSet<>();
        for (int ascii = 0; ascii < counts.length; ascii++) {
            if ((counts[ascii] > 0) && (counts[ascii] < k)) {
                lookup.add((char)(ascii + 'A'));
            }
        }

        // special case - if no boundary whole string is the longest
        if (lookup.size() == 0) {
            return right - left + 1;
        }

        int previous = -1;
        int maxLength = 0;
        for (int index = left; index <= right + 1; index++) {
            if ((index == right + 1) || (lookup.contains(s.charAt(index)))) {
                maxLength = Math.max(maxLength, recurse(s, k, previous + 1, index - 1));
                previous = index;
            }
        }

        return maxLength;
    }

}
