package leetcode.questions.data_structures.trie;

import leetcode.models.TrieNode;

/**
 Design a data structure that supports the following two operations:
 void addWord(word)
 bool search(word)


 search(word) can search a literal word or a regular expression string containing only letters a-z or ..
 A . means it can represent any one letter.

 For example:
 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad") -> false
 search("bad") -> true
 search(".ad") -> true
 search("b..") -> true

-------------------------------------------------------------------------------------------------

 We could do both suffix and prefix tree. But not sure how to optimize . in the middle...will try to backtrack first

 */
public class Add_Search_Word_211 {

    private TrieNode prefixRoot = new TrieNode();
    private TrieNode suffixRoot = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        this.addToRoot(this.prefixRoot, word);
        this.addToRoot(this.suffixRoot, reverse(word));
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if ((word == null) || (word.length() == 0)) {
            return false;
        }

        if (word.charAt(0) == '.') {
            return searchFromRoot(this.suffixRoot, reverse(word), 0);
        }
        return searchFromRoot(this.prefixRoot, word, 0);
    }

    private boolean searchFromRoot(TrieNode root, String word, int start) {
        TrieNode node = root;

        for (int index = start; index < word.length(); index++) {
            if (word.charAt(index) == '.') {
                for (TrieNode child : node.nodes) {
                    if (child != null) {
                        if (searchFromRoot(child, word, index + 1)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            else {
                TrieNode child = node.nodes[word.charAt(index) - 'a'];
                if (child == null) {
                    return false;
                }
                node = child;
            }
        }

        return node.isWord;
    }

    private String reverse(String word) {
        char[] chrs = word.toCharArray();

        int left = 0;
        int right = chrs.length - 1;
        while(left < right) {
            char tmp = chrs[left];
            chrs[left] = chrs[right];
            chrs[right] = tmp;
            left++;
            right--;
        }

        return new String(chrs);
    }

    private void addToRoot(TrieNode root, String word) {
        TrieNode node = root;

        for (char chr : word.toCharArray()) {
            TrieNode child = node.nodes[chr - 'a'];
            if (child == null) {
                child = new TrieNode();
                node.nodes[chr - 'a'] = child;
            }
            node = child;
        }

        node.isWord = true;
    }

}
