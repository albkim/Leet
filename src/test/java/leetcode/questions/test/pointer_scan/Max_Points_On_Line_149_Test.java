package leetcode.questions.test.pointer_scan;

import leetcode.models.Point;
import leetcode.questions.pointer_scan.Max_Points_On_Line_149;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/8/2016.
 */
public class Max_Points_On_Line_149_Test {

    @Test
    public void testEdge() {
        assertEquals(1, Max_Points_On_Line_149.maxPoints(new Point[] { new Point(0,0) }));
        assertEquals(2, Max_Points_On_Line_149.maxPoints(new Point[] { new Point(0,0), new Point(0,0) }));
        assertEquals(2, Max_Points_On_Line_149.maxPoints(new Point[] { new Point(1,1), new Point(2,1) }));
    }

    @Test
    public void testSimple() {
        assertEquals(3, Max_Points_On_Line_149.maxPoints(new Point[] { new Point(0,0), new Point(-1,-1), new Point(2,2) }));
    }

    @Test
    public void testSimple2() {
        assertEquals(3, Max_Points_On_Line_149.maxPoints(new Point[] { new Point(1,1), new Point(1,1), new Point(2,3) }));
    }

}
