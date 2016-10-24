package leetcode.questions.data_structures.stack;

import java.util.Stack;

/**
 Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 find the area of largest rectangle in the histogram.


 Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


 The largest rectangle is shown in the shaded area, which has area = 10 unit. (between 5 & 6)


 For example,
 Given heights = [2,1,5,6,2,3],
 return 10.


 --------------------------------------------------------------------------------------------------------------------


 Use a stack and push index and height in as long as the height is larger than root of the stack.
 Once a lower one is encountered, pop it until it's smaller and calculate the area


 */
public class Largest_Rectangle_Histogram_84 {

    private static class Record {
        public int index;
        public int height;

        public Record(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Record> tracker = new Stack<>();

        int max = 0;

        for (int index = 0; index <= heights.length; index++) {
            int height = index == heights.length ? 0 : heights[index];
            if ((tracker.empty()) || (tracker.peek().height <= height)) {
                tracker.push(new Record(index, height));
            }
            else {
                int lastIndex = index;
                while(true) {
                    if ((tracker.empty()) || (tracker.peek().height <= height)) {
                        // now consider something like 2,1,2. We shouldn't insert the current height
                        // at the current index, because rect with height 1 can be formed from the last
                        // popped point
                        tracker.push(new Record(lastIndex, height));
                        break;
                    }
                    else {
                        Record record = tracker.pop();
                        lastIndex = record.index;
                        max = Math.max(max, record.height * (index - record.index));
                    }
                }
            }
        }

        return max;
    }

}
