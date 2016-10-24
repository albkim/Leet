package leetcode.questions.data_structures.graph;

import java.util.*;

/**
 There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 For example:
 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

 2, [[1,0],[0,1]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

 Note:
 The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.


 ---------------------------------------------------------------------------------------------------------------

 Seems like topological sort?

 */
public class Course_Schedule_207 {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }

        Map<Integer, Set<Integer>> preLookup = new HashMap<>();
        Map<Integer, Set<Integer>> freeLookup = new HashMap<>();

        // create a lookup
        for (int[] pair : prerequisites) {
            if (preLookup.containsKey(pair[0])) {
                preLookup.get(pair[0]).add(pair[1]);
            }
            else {
                Set<Integer> dependencies = new HashSet<>();
                dependencies.add(pair[1]);
                preLookup.put(pair[0], dependencies);
            }
            if (!preLookup.containsKey(pair[1])) {
                preLookup.put(pair[1], new HashSet<>());
            }
            if (freeLookup.containsKey(pair[1])) {
                freeLookup.get(pair[1]).add(pair[0]);
            }
            else {
                Set<Integer> frees = new HashSet<>();
                frees.add(pair[0]);
                freeLookup.put(pair[1], frees);
            }
        }

        int courses = 0;
        while ((courses < numCourses) && (preLookup.size() > 0)) {
            List<Integer> canTake = new ArrayList<>();
            for (Map.Entry<Integer, Set<Integer>> course : preLookup.entrySet()) {
                if (course.getValue().size() == 0) {
                    canTake.add(course.getKey());
                }
            }

            if (canTake.size() == 0) {
                break;
            }

            for (int course : canTake) {
                preLookup.remove(course);
                if (freeLookup.containsKey(course)) {
                    for (int free : freeLookup.get(course)) {
                        preLookup.get(free).remove(course);
                    }
                }
                courses++;
            }
        }

        return courses == numCourses || preLookup.size() == 0;
    }

}
