package leetcode.questions.dp;

import leetcode.models.TrieNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

 Return all such possible sentences.

 For example, given
 s = "catsanddog",
 dict = ["cat", "cats", "and", "sand", "dog"].

 A solution is ["cats and dog", "cat sand dog"].

 -----------------------------------------------------------------------------------------------------

 Similar to I, just need to store all variations in dp and not break on the first match

 lol...timeout...what if we know we don't have to traverse further by using a trie.

 lol there are some inputs which will create so many variations it will turn most n^2 algo into n^3 which
 will not compute. This is not avoidable!

 Some test cases intentionally put unbreakable word to avoid the above and make it pass...so we should do the
 check first

 */
public class Word_Break_II_140 {

    public static List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<>();

        if ((s == null) || (s.length() == 0)) {
            return result;
        }

        if (!wordBreakDP(s, wordDict)) {
            return result;
        }

        TrieNode[] nodes = new TrieNode[60];

        // parse into trie
        for (String word : wordDict) {
            TrieNode node = null;
            TrieNode[] current = nodes;
            for (char chr : word.toCharArray()) {
                node = current[chr - 'a'] != null ? current[chr - 'a'] : null;
                if (node == null) {
                    node = new TrieNode();
                    current[chr - 'a'] = node;
                }

                current = node.nodes;
            }

            node.isWord = true;
        }

        List<List<String>>[] dp = new List[s.length()];

        char[] chrs = s.toCharArray();
        for (int i = s.length() - 1; i >= 0; i--) {
            List<List<String>> variations = new ArrayList<>();

            TrieNode[] current = nodes;
            for (int j = i; j < s.length(); j++) {
                TrieNode node = current[chrs[j] - 'a'] != null ? current[chrs[j] - 'a'] : null;
                if (node == null) {
                    break;
                }

                if (node.isWord) {
                    String word = s.substring(i, j + 1);
                    if ((j + 1) == dp.length) {
                        variations.add(Collections.singletonList(word));
                    }
                    else {
                        for (List<String> variation : dp[j + 1]) {
                            List<String> newVariation = new ArrayList<>(variation);
                            newVariation.add(0, word);
                            variations.add(newVariation);
                        }
                    }
                }

                current = node.nodes;
            }

            dp[i] = variations;
        }

        for (List<String> variation : dp[0]) {
            StringBuilder line = new StringBuilder();
            for (String word : variation) {
                if (line.length() > 0) {
                    line.append(" ");
                }
                line.append(word);
            }
            result.add(line.toString());
        }
        return result;
    }

    private static boolean wordBreakDP(String s, Set<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (wordDict.contains(s.substring(i, j + 1))) {
                    if (dp[j + 1]) {
                        dp[i] = dp[j + 1];
                        break;
                    }
                }
            }
        }

        return dp[0];
    }

}
