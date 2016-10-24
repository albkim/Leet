package leetcode.questions.data_structures.trie;

import leetcode.models.TrieNode;

/**
 Implement a trie with insert, search, and startsWith methods.

 Note:
 You may assume that all inputs are consist of lowercase letters a-z.

 */
public class Implement_Trie_Prefix_Tree_208 {

    private TrieNode root;

    public Implement_Trie_Prefix_Tree_208() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
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

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;

        for (int j = 0; j < word.length(); j++) {
            node = node.nodes[word.charAt(j) - 'a'];
            if (node == null) {
                break;
            }
        }

        return node != null && node.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;

        for (int j = 0; j < prefix.length(); j++) {
            node = node.nodes[prefix.charAt(j) - 'a'];
            if (node == null) {
                break;
            }
        }

        return node != null;
    }

}
