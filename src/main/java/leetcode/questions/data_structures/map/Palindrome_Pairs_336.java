package leetcode.questions.data_structures.map;

import java.util.*;

/**
 Given a list of unique words. Find all pairs of distinct indices (i, j) in the given list,
 so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

 Example 1:
 Given words = ["bat", "tab", "cat"]
 Return [[0, 1], [1, 0]]
 The palindromes are ["battab", "tabbat"]


 Example 2:
 Given words = ["abcd", "dcba", "lls", "s", "sssll"]
 Return [[0, 1], [1, 0], [3, 2], [2, 4]]
 The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]

 ----------------------------------------------------------------------------------------------------

 Use a map to lookup the possible palindrome
 e.g. for bat, search the map for tab, ab, ta

 */
public class Palindrome_Pairs_336 {

    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if((words == null) || (words.length == 0)) {
            return result;
        }

        Map<String, Integer> lookup = new HashMap<>();
        for (int index = 0; index < words.length; index++) {
            lookup.put(words[index], index);
        }

        for (int index = 0; index < words.length; index++) {
            StringBuilder sb = new StringBuilder(words[index]);
            sb.reverse();

            String full = sb.toString();
            if ((lookup.containsKey(full)) && (lookup.get(full) != index)) {
                result.add(Arrays.asList(index, lookup.get(full)));
            }

            // see if partial can be removed. We can remove any palindrome.
            for (int partialIndex = 0; partialIndex < sb.length(); partialIndex++) {
                if (isPalinedrome(sb, 0, partialIndex)) {
                    String partial = sb.substring(partialIndex + 1, sb.length());

                    if ((lookup.containsKey(partial)) && (lookup.get(partial) != index)) {
                        result.add(Arrays.asList(index, lookup.get(partial)));
                    }
                }
            }

            // need to do both sides
            for (int partialIndex = sb.length() - 1; partialIndex >= 0; partialIndex--) {
                if (isPalinedrome(sb, partialIndex, sb.length() - 1)) {
                    String partial = sb.substring(0, partialIndex);

                    if ((lookup.containsKey(partial)) && (lookup.get(partial) != index)) {
                        result.add(Arrays.asList(lookup.get(partial), index));
                    }
                }
            }
        }

        return result;
    }

    private static boolean isPalinedrome(StringBuilder word, int left, int right) {
        while(left <= right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

}
