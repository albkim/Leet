package leetcode.questions.data_structures.trie;

import leetcode.models.TrieNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 Given a 2D board and a list of words from the dictionary, find all words in the board.

 Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
 horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 For example,
 Given words = ["oath","pea","eat","rain"] and board =
 [
 ['o','a','a','n'],
 ['e','t','a','e'],
 ['i','h','k','r'],
 ['i','f','l','v']
 ]

 Return ["eat","oath"].

 Note:
 You may assume that all inputs are consist of lowercase letters a-z.

 -------------------------------------------------------------------------------------------------------------

 We can do dfs with backtrack and use trie to optimize the search

 */
public class Word_Search_II_212 {

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        if ((board == null) || (board.length == 0) || (board[0].length == 0) || (words == null) || (words.length == 0)) {
            return result;
        }

        TrieNode trie = createLookup(words);

        Set<String> unique = new HashSet<>();

        boolean[][] used = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                used[row][column] = true;
                dfs(unique, board, used, row, column, new ArrayList<>(), trie);
                used[row][column] = false;
            }
        }

        for (String word : unique) {
            result.add(word);
        }

        return result;
    }

    private static void dfs(Set<String> result, char[][] board, boolean[][] used, int row, int column, List<Character> current, TrieNode trie) {
        char currentChar = board[row][column];
        TrieNode node = trie.nodes[currentChar - 'a'];

        if (node == null) {
            return;
        }

        current.add(currentChar);

        if (node.isWord) {
            StringBuilder word = new StringBuilder();
            for (char chr : current) {
                word.append(chr);
            }
            result.add(word.toString());
        }

        int[][] directions = new int[][] {
                new int[] {-1, 0},
                new int[] {1, 0},
                new int[] {0, -1},
                new int[] {0, 1}
        };

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newColumn = column + direction[1];

            if ((newRow >= 0) && (newRow < board.length) && (newColumn >= 0) && (newColumn < board[0].length)
                    && (!used[newRow][newColumn])) {
                used[newRow][newColumn] = true;
                dfs(result, board, used, newRow, newColumn, current, node);
                used[newRow][newColumn] = false;
            }
        }

        current.remove(current.size() - 1);
    }

    private static TrieNode createLookup(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode current = root;
            for (char chr : word.toCharArray()) {
                TrieNode child = current.nodes[chr - 'a'];
                if (child == null) {
                    child = new TrieNode();
                    current.nodes[chr - 'a'] = child;
                }
                current = child;
            }
            current.isWord = true;
        }

        return root;
    }

}
