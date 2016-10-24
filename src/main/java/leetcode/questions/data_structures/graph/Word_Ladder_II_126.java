package leetcode.questions.data_structures.graph;

import java.util.*;

/**
 Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s)
 from beginWord to endWord, such that:

 1.Only one letter can be changed at a time
 2.Each intermediate word must exist in the word list

 For example,

 Given:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]


 Return

 [
 ["hit","hot","dot","dog","cog"],
 ["hit","hot","lot","log","cog"]
 ]

 Note:

 •All words have the same length.
 •All words contain only lowercase alphabetic characters.

 ------------------------------------------------------------------------------------------------------------------

 So...since we have to find all variations of shortest path, seems like we need to DFS (instead of BFS). Could we
 update global shortest path length, so we can eliminate paths as we find shorter paths

 lol not fast enough...

 What if we get bfs to get the shortest path and construct the graph as we go. Then it's just matter of dfs this graph
 to find all possible paths.

 */
public class Word_Ladder_II_126 {

    public static List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> result = new ArrayList<>();

        Map<String, Set<String>> graph = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Set<String> next = new HashSet<>();

        List<Set<String>> leftGraph = new ArrayList<>();
        Set<String> left = new HashSet<>();
        left.add(beginWord);
        leftGraph.add(left);
        List<Set<String>> rightGraph = new ArrayList<>();
        Set<String> right = new HashSet<>();
        right.add(endWord);
        rightGraph.add(right);

        boolean tryLeft = true;
        while(!(tryLeft ? left : right).isEmpty()) {
            if (bfs(wordList, visited, (tryLeft ? left : right), (tryLeft ? right : left), next, graph)) {
                List<String> path = new ArrayList<>();
                path.add(beginWord);
                visited.clear();
                visited.add(beginWord);

                List<Set<String>> levels = new ArrayList<>();
                for (int index = 1; index < leftGraph.size(); index++) {
                    levels.add(leftGraph.get(index));
                }
                for (int index = rightGraph.size() - 1; index >= 0; index--) {
                    levels.add(rightGraph.get(index));
                }
                dfs(result, levels, graph, visited, path, 0);
                break;
            }
            if (tryLeft) {
                left = next;
                leftGraph.add(left);
            }
            else {
                right = next;
                rightGraph.add(right);
            }
            next = new HashSet<>();
            tryLeft = !tryLeft;
        }

        return result;
    }

    private static boolean bfs(Set<String> wordList, Set<String> visited, Set<String> current, Set<String> theOther, Set<String> next, Map<String, Set<String>> graph) {
        boolean found = false;
        for (String node : current) {
            visited.add(node);

            StringBuilder newString = new StringBuilder(node);
            for (int index = 0; index < node.length(); index++) {
                for (char chr = 'a'; chr <= 'z'; chr++) {
                    newString.setCharAt(index, chr);
                    String modified = newString.toString();
                    if (wordList.contains(modified)) {
                        if (theOther.contains(modified)) {
                            found = true;
                        }
                        if (!visited.contains(modified)) {
                            next.add(modified);
                        }
                        addToGraph(graph, node, modified);
                        addToGraph(graph, modified, node);
                    }
                }
                newString.setCharAt(index, node.charAt(index));
            }
        }
        return found;
    }

    private static void dfs(List<List<String>> result, List<Set<String>> levels, Map<String, Set<String>> graph, Set<String> visited, List<String> current, int depth) {
        if (depth == levels.size()) {
            result.add(new ArrayList<>(current));
            return;
        }

        String node = current.get(current.size() - 1);
        for (String candidate : levels.get(depth)) {
            if ((!visited.contains(candidate)) && (graph.get(node).contains(candidate))) {
                visited.add(candidate);
                current.add(candidate);
                dfs(result, levels, graph, visited, current, depth + 1);
                visited.remove(candidate);
                current.remove(current.size() - 1);
            }
        }
    }

    private static void addToGraph(Map<String, Set<String>> graph, String left, String right) {
        if (graph.containsKey(left)) {
            graph.get(left).add(right);
        }
        else {
            Set<String> neighbors = new HashSet<>();
            neighbors.add(right);
            graph.put(left, neighbors);
        }
    }

}
