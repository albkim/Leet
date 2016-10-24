package leetcode.questions.data_structures.heap;

import java.util.*;

/**
 A city's skyline is the outer contour of the silhouette formed by all the buildings in that city
 when viewed from a distance. Now suppose you are given the locations and height of all the buildings
 as shown on a cityscape photo (Figure A), write a program to output the skyline formed by
 these buildings collectively (Figure B).

 The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi],
 where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively,
 and Hi is its height. It is guaranteed that 0 ? Li, Ri ? INT_MAX, 0 < Hi ? INT_MAX, and Ri - Li > 0.
 You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

 For instance, the dimensions of all buildings in Figure A are recorded as:
 [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

 The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ]
 that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last
 key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always
 has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.

 For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].

 Notes:
 • The number of buildings in any input list is guaranteed to be in the range [0, 10000].
 • The input list is already sorted in ascending order by the left x position Li.
 • The output list must be sorted by the x position.
 • There must be no consecutive horizontal lines of equal height in the output skyline. For instance,
 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged
 into one in the final output as such: [...[2 3], [4 5], [12 7], ...]

 -------------------------------------------------------------------------------------------------------

 Use a heap to track max height. As we go through all x1, x2 of all buildings in order, either add or remove the height
 from the heap and then calculate area

 */
public class The_Skyline_Problem_218 {

    private static class Building {
        public int x;
        public int h;
        public boolean begin;

        public Building(int x, int h, boolean begin) {
            this.x = x;
            this.h = h;
            this.begin = begin;
        }
    }

    public static List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        if ((buildings == null) || (buildings.length == 0)) {
            return result;
        }

        List<Building> sortedBuildings = new ArrayList<>();

        for (int[] building : buildings) {
            sortedBuildings.add(new Building(building[0], building[2], true));
            sortedBuildings.add(new Building(building[1], building[2], false));
        }

        sortedBuildings.sort(new Comparator<Building>() {
            @Override
            public int compare(Building o1, Building o2) {
                // complex logic here... asc x, desc begin, asc h
                if (o1.x == o2.x) {
                    if (o1.begin == o2.begin) {
                        if (o1.begin) {
                            return o2.h - o1.h;
                        }
                        else {
                            return o1.h - o2.h;
                        }
                    }

                    if (o1.begin) {
                        return -1;
                    } else if (o2.begin) {
                        return 1;
                    }
                }
                return o1.x - o2.x;
            }
        });

        Queue<Integer> heights = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.intValue() - o1.intValue();
            }
        });

        int previousX = Integer.MIN_VALUE;
        for (Building building : sortedBuildings) {
            if (previousX > Integer.MIN_VALUE) {
                int height = (heights.size() > 0) ? heights.peek().intValue() : 0;

                // do one check. If the height/or x is equal to previous, we don't need to insert
                if ((result.size() == 0) || ((result.get(result.size() - 1)[1] != height)
                        && (result.get(result.size() - 1)[0] != previousX) && (building.x != previousX))) {
                    result.add(new int[] {previousX, height});
                }
            }
            if (building.begin) {
                heights.add(building.h);
            }
            else {
                heights.remove(building.h);
            }
            previousX = building.x;
        }

        // last one
        result.add(new int[] {previousX, 0});

        return result;
    }

}
