package leetcode.questions.data_structures.map;

import java.util.HashMap;
import java.util.Map;

/**
 Given a pattern and a string str, find if str follows the same pattern.

 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

 Examples:

 1.pattern = "abba", str = "dog cat cat dog" should return true.
 2.pattern = "abba", str = "dog cat cat fish" should return false.
 3.pattern = "aaaa", str = "dog cat cat dog" should return false.
 4.pattern = "abba", str = "dog dog dog dog" should return false.


 Notes:
 You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space

 -------------------------------------------------------------------------------------------------------

 Simple 2 map lookup

 */
public class Word_Pattern_290 {

    public static boolean wordPattern(String pattern, String str) {
        Map<Character, String> letterLookup = new HashMap<>();
        Map<String, Character> wordLookup = new HashMap<>();

        String[] words = str.split(" ");

        // index out of bound check
        if (words.length != pattern.length()) {
            return false;
        }

        for (int index = 0; index < pattern.length(); index++) {
            char chr = pattern.charAt(index);
            String word = words[index];

            if (letterLookup.containsKey(chr)) {
                if (!word.equals(letterLookup.get(chr))) {
                    return false;
                }
            }
            else {
                letterLookup.put(chr, word);
            }
            if (wordLookup.containsKey(word)) {
                if (chr != wordLookup.get(word)) {
                    return false;
                }
            }
            else {
                wordLookup.put(word, chr);
            }
        }
        return true;
    }

}
