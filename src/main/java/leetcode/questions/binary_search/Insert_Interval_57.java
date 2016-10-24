package leetcode.questions.binary_search;

import leetcode.models.Interval;

import java.util.List;

/**
 Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:
 Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

 Example 2:
 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].


 -----------------------------------------------------------------------------------------------------

 Seems similar to merging intervals. I can maybe do a binary search for any interval where the new starting
 point is <= endpoint. If one is found, then linearly scan either side to find any other ones. If not found
 just insert

 */
public class Insert_Interval_57 {

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int start = 0;
        int end = intervals.size() - 1;

        int leftBound = Integer.MIN_VALUE;
        int rightBound = Integer.MIN_VALUE;
        while(start <= end) {
            int mid = start + ((end - start) >> 1);
            Interval midInterval = intervals.get(mid);

            // check for overlap
            // ----                  ------             ------
            //    ----            ------               --------
            if (((midInterval.start <= newInterval.start) && (midInterval.end >= newInterval.start)) ||
                    ((midInterval.start <= newInterval.end) && (midInterval.end >= newInterval.end)) ||
                    ((midInterval.start >= newInterval.start) && (midInterval.end <= newInterval.end))){
                // found it, find other candidates
                leftBound = mid;
                while(leftBound >= 0) {
                    if (intervals.get(leftBound).end < newInterval.start) {
                        break;
                    }
                    leftBound--;
                }

                rightBound = mid;
                while(rightBound < intervals.size()) {
                    if (intervals.get(rightBound).start > newInterval.end) {
                        break;
                    }
                    rightBound++;
                }

                break;
            }
            else if (midInterval.end < newInterval.start) {
                // move right
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        // now two cases, we found a range to merge, or we found an insertion point
        if ((leftBound != Integer.MIN_VALUE) && (rightBound != Integer.MIN_VALUE)) {
            for (int index = rightBound - 1; index > leftBound; index--) {
                Interval interval = intervals.get(index);
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
                intervals.remove(index);
            }
            intervals.add(leftBound + 1, newInterval);
        }
        else {
            intervals.add(start, newInterval);
        }

        return intervals;
    }

}
