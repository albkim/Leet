package leetcode.questions.data_structures.graph;

import java.util.*;

/**
 Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest
 transformation sequence from beginWord to endWord, such that:

 1.Only one letter can be changed at a time
 2.Each intermediate word must exist in the word list

 For example,

 Given:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]


 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.

 Note:

 �Return 0 if there is no such transformation sequence.
 �All words have the same length.
 �All words contain only lowercase alphabetic characters.

 -------------------------------------------------------------------------------------------------------------------

 If we can create a graph out of all the words set, we can do BFS for shortest path

 -- looks like constructing a graph takes too long, instead we can find neighbors by trying to change each char of current
 from a-z and then checking if it's in the set

 -- even above is not fast enough. We can do two vertex traversal, limiting the traversal to less

 */
public class Word_Ladder_127 {

    public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        int nodeCount = 1;
        Set<String> visited = new HashSet<>();

        Set<String> next = new HashSet<>();

        Set<String> left = new HashSet<>();
        left.add(beginWord);

        Set<String> right = new HashSet<>();
        right.add(endWord);

        boolean tryLeft = true;
        while(!(tryLeft ? left : right).isEmpty()) {
            if (bfs(wordList, visited, (tryLeft ? left : right), (tryLeft ? right : left), next)) {
                return nodeCount + 1;
            }
            if (tryLeft) {
                left = next;
            }
            else {
                right = next;
            }
            next = new HashSet<>();
            tryLeft = !tryLeft;
            nodeCount++;
        }

        return 0;
    }

    private static boolean bfs(Set<String> wordList, Set<String> visited, Set<String> current, Set<String> theOther, Set<String> next) {
        for (String node : current) {
            visited.add(node);

            StringBuilder newString = new StringBuilder(node);
            for (int index = 0; index < node.length(); index++) {
                for (char chr = 'a'; chr <= 'z'; chr++) {
                    newString.setCharAt(index, chr);
                    String modified = newString.toString();
                    if (wordList.contains(modified)) {
                        if (theOther.contains(modified)) {
                            return true;
                        }
                        if (!visited.contains(modified)) {
                            next.add(modified);
                        }
                    }
                }
                newString.setCharAt(index, node.charAt(index));
            }
        }
        return false;
    }

}
