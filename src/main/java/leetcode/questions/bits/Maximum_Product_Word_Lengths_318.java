package leetcode.questions.bits;

/**
 Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do
 not share common letters. You may assume that each word will contain only lower case letters.
 If no such two words exist, return 0.

 Example 1:

 Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 Return 16
 The two words can be "abcw", "xtfn".

 Example 2:


 Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 Return 4
 The two words can be "ab", "cd".

 Example 3:


 Given ["a", "aa", "aaa", "aaaa"]
 Return 0
 No such pair of words.

 ----------------------------------------------------------------------------------------------

 Seems like there is no trick...try all permutations

 One trick is to use space (we could have use boolean[][]...and it would be O(n). One trick is to use a bit mask for letter
 since 32 > 26 letters to decrease space.

 */
public class Maximum_Product_Word_Lengths_318 {

    public static int maxProduct(String[] words) {
        int max = 0;
        for (int first = 0; first < words.length - 1; first++) {
            boolean[] lookup = new boolean[26];
            for (char chr : words[first].toCharArray()) {
                lookup[chr - 'a'] = true;
            }
            for (int second = first + 1; second < words.length; second++) {
                boolean found = false;
                for (char chr : words[second].toCharArray()) {
                    if (lookup[chr - 'a']) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    max = Math.max(max, words[first].length() * words[second].length());
                }
            }
        }
        return max;
    }

}
