package leetcode.questions.pointer_scan;

import java.util.*;

/**
 You are given a string, s, and a list of words, words, that are all of the same length.
 Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly
 once and without any intervening characters.

 For example, given:
 s: "barfoothefoobarman"
 words: ["foo", "bar"]

 You should return the indices: [0,9].
 (order does not matter).

 */
public class Substring_With_Concatenation_All_Words_30 {

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int length = wordLength * words.length;
        if (s.length() < length) {
            return result;
        }

        // create a lookup of words with counts (since we can have multiple instances of a word)
        Map<String, Integer> wordLookup = new HashMap<>();
        for (String word : words) {
            if (wordLookup.containsKey(word)) {
                wordLookup.put(word, wordLookup.get(word) + 1);
            }
            else {
                wordLookup.put(word, 1);
            }
        }

        // find a candidate index as we scan left to right, we only need to start from various word positions
        // since each word is of equal length
        for(int startIndex = 0; startIndex < wordLength; startIndex++) {
            int index = startIndex;
            int windowStart = startIndex;
            Map<String, List<Integer>> tracking = new HashMap<>();
            while (index <= (s.length() - wordLength)) {
                // three conditions
                // no match, we start again from next word
                // match, we look at current set to see if it's good, and do cleanup
                // match but already in tracking set, then we start again from current
                String candidate = s.substring(index, index + wordLength);
                if (wordLookup.containsKey(candidate)) {
                    List<Integer> wordIndexes;
                    if (!tracking.containsKey(candidate)) {
                        wordIndexes = new ArrayList<>();
                        tracking.put(candidate, wordIndexes);
                    }
                    else {
                        wordIndexes = tracking.get(candidate);

                        // if adding current word will be more than allowed occurrence
                        if (wordIndexes.size() > (wordLookup.get(candidate) - 1)) {
                            // need to handle special case, we now need to discard first occurrence of this dupe
                            int newWindowStart = wordIndexes.get(0) + wordLength;

                            // clean up tracking
                            for (int cleanIndex = windowStart; cleanIndex < newWindowStart; cleanIndex+= wordLength) {
                                String clean = s.substring(cleanIndex, cleanIndex + wordLength);
                                List<Integer> wordIndexesClean = tracking.get(clean);
                                wordIndexesClean.remove(0);
                            }

                            // reset index
                            windowStart = newWindowStart;
                        }

                    }

                    wordIndexes.add(index);

                    int windowLength = index + wordLength - windowStart;
                    if (windowLength == length) {
                        // we found a match
                        result.add(windowStart);

                        // now remove the very beginning
                        String wordToRemove = s.substring(windowStart, windowStart + wordLength);
                        wordIndexes = tracking.get(wordToRemove);
                        if (wordIndexes.size() == 1) {
                            tracking.remove(wordToRemove);
                        }
                        else {
                            wordIndexes.remove(0);
                        }
                        windowStart += wordLength;
                    }
                }
                else {
                    // since there is no way it could have continuous pattern, reset everything
                    windowStart = index + wordLength;
                    tracking.clear();
                }

                index += wordLength;
            }
        }

        return result;
    }

}
