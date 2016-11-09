package leetcode.questions.binary_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 Given a string s and a string t, check if s is subsequence of t.

 You may assume that there is only lower case English letters in both s and t. t is potentially a very long
 (length ~= 500,000) string, and s is a short string (<=100).

 A subsequence of a string is a new string which is formed from the original string by deleting some (can be none)
 of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence
 of "abcde" while "aec" is not).

 Example 1:
 s = "abc", t = "ahbgdc"

 Return true.

 Example 2:
 s = "axc", t = "ahbgdc"

 Return false.

 Follow up:
 If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T
 has its subsequence. In this scenario, how would you change your code?

 ------------------------------------------------------------------------------------------------------------

 If I create a lookup of all characters and indexes, I can just search for occurrence of each character after each index
 We could even optimize the search using binary search (find smallest after k)

 watch out for same character...so we need to make sure index is always greater than current when doing binary search

 */
public class Is_Subsequence_392 {

    public static boolean isSubsequence(String s, String t) {
        Map<Character, List<Integer>> lookup = new HashMap<>();

        for (int index = 0; index < t.length(); index++) {
            char chr = t.charAt(index);
            lookup.putIfAbsent(chr, new ArrayList<>());
            lookup.get(chr).add(index);
        }

        int index = -1;
        for (char chr : s.toCharArray()) {
            if (!lookup.containsKey(chr)) {
                return false;
            }

            index = search(lookup.get(chr), index);

            if (index == Integer.MAX_VALUE) {
                return false;
            }
        }

        return true;
    }

    private static int search(List<Integer> indexes, int index) {
        int left = 0;
        int right = indexes.size() - 1;

        int smallest = Integer.MAX_VALUE;
        while(left <= right) {
            int mid = left + ((right - left) >> 1);
            if (indexes.get(mid) <= index) {
                left = mid + 1;
            }
            else {
                smallest = Math.min(smallest, indexes.get(mid));
                right = mid - 1;
            }
        }
        return smallest;
    }

}
