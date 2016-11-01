package leetcode.questions.pointer_scan;

/**
 Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 Find two lines, which together with x-axis forms a container, such that the container contains the most water.

 Note: You may not slant the container.

 ----------------------------------------------------------------------------------------------------------------------

 This is interesting, since we are interested in area, we want to either maximize the distance between two lines
 or the height.

 Proof for O(n)

 row is first line and column is the second line.
 brute force solution would calculate all these points. But the diagonal is same line. The left bottom x's are same as
 top right section (1-6 is same as 6-1....same for 2-3 & 3-2)
 1 2 3 4 5 6
 1 x ------- o
 2 x x
 3 x x x
 4 x x x x
 5 x x x x x
 6 x x x x x x

 so look at 1-6. the area is bounded by the smaller of the two. If 1 is smaller, any 1-x combination cannot be greater
 than 1-6 (maximum x....and no matter how high/small 2 to 5 is 1 would dictate the area with decreasing x.

 so we only need to consider 2 to 6 and move the smaller side in.
 */
public class Container_With_Most_Water_11 {

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;
        while(left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            if (area > maxArea) {
                maxArea = area;
            }

            if (height[left] < height[right]) {
                left++;
            }
            else {
                right--;
            }
        }

        return maxArea;
    }

}
