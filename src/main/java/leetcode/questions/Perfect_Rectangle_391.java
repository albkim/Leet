package leetcode.questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 Given N axis-aligned rectangles where N > 0, determine if they all together form an exact cover of a rectangular region.

 Each rectangle is represented as a bottom-left point and a top-right point. For example, a unit square is represented
 as [1,1,2,2]. (coordinate of bottom-left point is (1, 1) and top-right point is (2, 2)).

 Example 1:
 rectangles = [
 [1,1,3,3],
 [3,1,4,2],
 [3,2,4,4],
 [1,3,2,4],
 [2,3,3,4]
 ]

 Return true. All 5 rectangles together form an exact cover of a rectangular region.

 Example 2:
 rectangles = [
 [1,1,2,3],
 [1,3,2,4],
 [3,1,4,2],
 [3,2,4,4]
 ]

 Return false. Because there is a gap between the two rectangular regions.

 Example 3:
 rectangles = [
 [1,1,3,3],
 [3,1,4,2],
 [1,3,2,4],
 [3,2,4,4]
 ]

 Return false. Because there is a gap in the top center.


 Example 4:
 rectangles = [
 [1,1,3,3],
 [3,1,4,2],
 [1,3,2,4],
 [2,2,4,4]
 ]

 Return false. Because two of the rectangles overlap with each other.

---------------------------------------------------------------------------------------------------------------

 Not even sure how one would ask this question...but seems like following has to be true for perfect rectangle

    The area of sub rectangles are equal to the total area
    the 4 corner should not overlap any vertexes
    other than 4 corners, each vertex should overlap exactly even numbers...(not just once...think of 4 equal squares, the center will
        overlap 4 times)

 */
public class Perfect_Rectangle_391 {

    private static class Point {
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            Point other = (Point)o;
            return this.x == other.x && this.y == other.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.x, this.y);
        }
    }

    public static boolean isRectangleCover(int[][] rectangles) {
        long totalArea = 0;
        int[] uberRectangle = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        Map<Point, Integer> corners = new HashMap<>();
        for (int[] rectangle : rectangles) {
            uberRectangle[0] = Math.min(uberRectangle[0], rectangle[0]);
            uberRectangle[1] = Math.min(uberRectangle[1], rectangle[1]);
            uberRectangle[2] = Math.max(uberRectangle[2], rectangle[2]);
            uberRectangle[3] = Math.max(uberRectangle[3], rectangle[3]);

            totalArea += (rectangle[2] - rectangle[0]) * (rectangle[3] - rectangle[1]);

            Point bottomLeft = new Point(rectangle[0], rectangle[1]);
            Point bottomRight = new Point(rectangle[0], rectangle[3]);
            Point topLeft = new Point(rectangle[2], rectangle[1]);
            Point topRight = new Point(rectangle[2], rectangle[3]);

            corners.put(bottomLeft, corners.getOrDefault(bottomLeft, 0) + 1);
            corners.put(bottomRight, corners.getOrDefault(bottomRight, 0) + 1);
            corners.put(topLeft, corners.getOrDefault(topLeft, 0) + 1);
            corners.put(topRight, corners.getOrDefault(topRight, 0) + 1);
        }

        // check area
        if (totalArea != (uberRectangle[2] - uberRectangle[0]) * (uberRectangle[3] - uberRectangle[1])) {
            return false;
        }

        // check 4 corners
        int[][] outerCorners = new int[][] {
                {uberRectangle[0], uberRectangle[1]},
                {uberRectangle[0], uberRectangle[3]},
                {uberRectangle[2], uberRectangle[1]},
                {uberRectangle[2], uberRectangle[3]}
        };
        for (int[] outerCorner : outerCorners) {
            Point corner = new Point(outerCorner[0], outerCorner[1]);
            if ((!corners.containsKey(corner)) || (corners.get(corner) != 1)) {
                return false;
            }
            corners.remove(corner);
        }

        // check all other points
        for (int count : corners.values()) {
            if ((count % 2) != 0) {
                return false;
            }
        }

        return true;
    }

}
