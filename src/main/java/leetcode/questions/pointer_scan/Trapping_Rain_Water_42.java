package leetcode.questions.pointer_scan;

/**
 Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

 For example,
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

 The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 In this case, 6 units of rain water (blue section) are being trapped.

 */
public class Trapping_Rain_Water_42 {

    public static int trap(int[] height) {
        int sumSpace = 0;
        int leftWallIndex = 0;
        int rightWallIndex = height.length - 1;

        // we should try to move the smaller wall towards he middle
        while (leftWallIndex < rightWallIndex) {
            int index;
            int wall;
            int wallIndex;
            int increment;

            if (height[leftWallIndex] < height[rightWallIndex]) {
                wallIndex = leftWallIndex;
                index = leftWallIndex + 1;
                wall = height[leftWallIndex];
                increment = 1;
            }
            else {
                wallIndex = rightWallIndex;
                index = rightWallIndex - 1;
                wall = height[rightWallIndex];
                increment = -1;
            }

            int sumSmaller = 0;
            while (height[index] < wall) {
                sumSmaller += height[index];
                index += increment;
            }

            // if other wall is bigger, we should calculate the available space
            sumSpace += (Math.abs(index - wallIndex) - 1) * Math.min(height[index], wall) - sumSmaller;
            if (height[leftWallIndex] < height[rightWallIndex]) {
                leftWallIndex = index;
            }
            else {
                rightWallIndex = index;
            }
        }

        return sumSpace;
    }

}
