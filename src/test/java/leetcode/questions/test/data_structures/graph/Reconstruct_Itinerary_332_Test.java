package leetcode.questions.test.data_structures.graph;

import leetcode.questions.data_structures.graph.Reconstruct_Itinerary_332;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/22/2016.
 */
public class Reconstruct_Itinerary_332_Test {

    @Test
    public void testEdge() {
        List<String> result = Reconstruct_Itinerary_332.findItinerary(new String[][] {
                {"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}
        });

        assertEquals("JFK", result.get(0));
        assertEquals("NRT", result.get(1));
        assertEquals("JFK", result.get(2));
        assertEquals("KUL", result.get(3));
    }

    @Test
    public void testSimple() {
        List<String> result = Reconstruct_Itinerary_332.findItinerary(new String[][] {
                {"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}
        });

        assertEquals("JFK", result.get(0));
        assertEquals("MUC", result.get(1));
        assertEquals("LHR", result.get(2));
        assertEquals("SFO", result.get(3));
        assertEquals("SJC", result.get(4));
    }

    @Test
    public void testSimple1() {
        List<String> result = Reconstruct_Itinerary_332.findItinerary(new String[][] {
                {"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}
        });

        assertEquals("JFK", result.get(0));
        assertEquals("ATL", result.get(1));
        assertEquals("JFK", result.get(2));
        assertEquals("SFO", result.get(3));
        assertEquals("ATL", result.get(4));
        assertEquals("SFO", result.get(5));
    }

    @Test
    public void testSimple2() {
        List<String> result = Reconstruct_Itinerary_332.findItinerary(new String[][] {
                {"EZE","AXA"},{"TIA","ANU"},{"ANU","JFK"},{"JFK","ANU"},{"ANU","EZE"},{"TIA","ANU"},{"AXA","TIA"},{"TIA","JFK"},{"ANU","TIA"},{"JFK","TIA"}
        });

        assertEquals("JFK", result.get(0));
        assertEquals("ANU", result.get(1));
        assertEquals("EZE", result.get(2));
        assertEquals("AXA", result.get(3));
        assertEquals("TIA", result.get(4));
        assertEquals("ANU", result.get(5));
    }

    @Test
    public void testSimple3() {
        List<String> result = Reconstruct_Itinerary_332.findItinerary(new String[][] {
                {"EZE","TIA"},{"EZE","HBA"},{"AXA","TIA"},{"JFK","AXA"},{"ANU","JFK"},{"ADL","ANU"},{"TIA","AUA"},{"ANU","AUA"},{"ADL","EZE"},{"ADL","EZE"},{"EZE","ADL"},{"AXA","EZE"},{"AUA","AXA"},{"JFK","AXA"},{"AXA","AUA"},{"AUA","ADL"},{"ANU","EZE"},{"TIA","ADL"},{"EZE","ANU"},{"AUA","ANU"}
        });
    }

}
