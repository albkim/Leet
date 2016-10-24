package leetcode.questions.data_structures.graph;

import java.util.*;

/**
 For a undirected graph with tree characteristics, we can choose any node as the root.
 The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height
 are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs
 and return a list of their root labels.

 Format
 The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a
 list of undirected edges (each edge is a pair of labels).

 You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1]
 is the same as [1, 0] and thus will not appear together in edges.

 Example 1:

 Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]
   0
   |
   1
  / \
 2   3


 return  [1]

 Example 2:

 Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 0  1  2
  \ | /
    3
    |
    4
    |
    5

 return  [3, 4]

 -------------------------------------------------------------------------------------------------------------

 Looks like we need to find the two leafs and bfs from there. Once we hit visited node, in the same iteration
 the nodes in that level is the possible root

 while above idea works in a simple structure, doesn't work if it branches out 2+ ways.

         0 - 1 - 2 - 4 - 6
           /
         3
       /
      5

 The correct solution is to point traversing from every leaf, when two meets, merge them until there is only 2 points
 remain. either they merge (in the same iteration) or they both are the root.


 */
public class Minimum_Height_Trees_310 {

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // by definition
        if (n == 0) {
            return new ArrayList<>();
        }
        if (n == 1) {
            return Arrays.asList(0);
        }

        Map<Integer, Set<Integer>> neighbors = new HashMap<>();
        for (int count = 0; count < n; count++) {
            neighbors.put(count, new HashSet<>());
        }
        for (int[] edge : edges) {
            neighbors.get(edge[0]).add(edge[1]);
            neighbors.get(edge[1]).add(edge[0]);
        }

        while(neighbors.size() > 0) {
            List<Integer> current = new ArrayList<>();
            for (Map.Entry<Integer, Set<Integer>> e : neighbors.entrySet()) {
                if (e.getValue().size() <= 1) {
                    current.add(e.getKey());
                }
            }

            // now if we have 1 or 2 left we have reached the root node. By definition, if we have 2 it has to be the root
            // and we cannot have more than 2
            if (neighbors.size() <= 2) {
                return current;
            }

            for(int leaf: current) {
                // remove this left node from neighbor
                for (int neighbor : neighbors.get(leaf)) {
                    neighbors.get(neighbor).remove(leaf);
                }
            }

            // now remove current
            for(int leaf : current) {
                neighbors.remove(leaf);
            }
        }

        return new ArrayList<>();
    }

}
