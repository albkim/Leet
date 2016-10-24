package leetcode.questions.data_structures.graph;

import java.util.*;

/**
 Given a list of airline tickets represented by pairs of departure and arrival airports [from, to],
 reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus,
 the itinerary must begin with JFK.

 Note:

 1.If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical
 order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 2.All airports are represented by three capital letters (IATA code).
 3.You may assume all tickets form at least one valid itinerary.


 Example 1:
 tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 Return ["JFK", "MUC", "LHR", "SFO", "SJC"].


 Example 2:
 tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
 Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.

 -------------------------------------------------------------------------------------------------------------

 Seems like a traversal with lexical ordering...nope need to backtrack since we may not successfully reach the final
 destination

 */
public class Reconstruct_Itinerary_332 {

    public static List<String> findItinerary(String[][] tickets) {
        List<String> result = new ArrayList<>();
        if ((tickets == null) || (tickets.length == 0)) {
            return result;
        }

        Map<String, List<String>> destinations = new HashMap<>();
        for (String[] ticket : tickets) {
            destinations.put(ticket[0], destinations.getOrDefault(ticket[0], new ArrayList<>()));
            destinations.get(ticket[0]).add(ticket[1]);
        }

        List<String> iternerary = new ArrayList<>();
        iternerary.add("JFK");

        backtrack(result, destinations, iternerary, tickets.length + 1);
        return result;
    }

    private static boolean backtrack(List<String> result, Map<String, List<String>> destinations, List<String> iternerary, int target) {
        if (iternerary.size() == target) {
            for(String airport : iternerary) {
                result.add(airport);
            }
            return true;
        }

        String current = iternerary.get(iternerary.size() - 1);

        if (!destinations.containsKey(current)) {
            // wrong order, we'd get here if we somehow decided pick the last destination
            return false;
        }

        List<String> candidates = new ArrayList<>(destinations.get(current));
        Collections.sort(candidates);

        // already sorted, so pick the beginning
        // we also have to make sure this is not the last destination (if we cannot find it from source)
        for (String possible : candidates) {
            iternerary.add(possible);
            destinations.get(current).remove(possible);
            if (backtrack(result, destinations, iternerary, target)) {
                return true;
            }
            iternerary.remove(iternerary.size() - 1);
            destinations.get(current).add(possible);
        }

        return false;
    }

}
