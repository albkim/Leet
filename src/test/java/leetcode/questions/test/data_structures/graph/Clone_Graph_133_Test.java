package leetcode.questions.test.data_structures.graph;

import leetcode.models.UndirectedGraphNode;
import leetcode.questions.data_structures.graph.Clone_Graph_133;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/5/2016.
 */
public class Clone_Graph_133_Test {

    @Test
    public void testSimple() {
        UndirectedGraphNode zero = new UndirectedGraphNode(0);
        UndirectedGraphNode one = new UndirectedGraphNode(1);
        UndirectedGraphNode two = new UndirectedGraphNode(2);

        zero.neighbors.add(one);
        zero.neighbors.add(two);
        one.neighbors.add(two);
        two.neighbors.add(two);

        UndirectedGraphNode copyZero = Clone_Graph_133.cloneGraph(zero);

        assertNotEquals(zero, copyZero);
        assertEquals(2, copyZero.neighbors.size());
        assertNotEquals(one, copyZero.neighbors.get(0));
        assertEquals(1, copyZero.neighbors.get(0).label);
        assertNotEquals(two, copyZero.neighbors.get(1));
        assertEquals(2, copyZero.neighbors.get(1).label);

        assertEquals(1, copyZero.neighbors.get(0).neighbors.size());
        assertEquals(2, copyZero.neighbors.get(0).neighbors.get(0).label);

        assertEquals(1, copyZero.neighbors.get(1).neighbors.size());
        assertEquals(2, copyZero.neighbors.get(1).neighbors.get(0).label);
    }

}
