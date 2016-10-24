package leetcode.questions.data_structures.heap;

import leetcode.models.Interval;

import java.util.*;

/**
 *
 Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].


 --------------------------------------------------------------------------------------------------

 Maybe use a priority queue to sort the tuples by starting point. We can then check if current
 tuples starting point is before last point's endpoint and merge the endpoints

 */
public class Merge_Intervals_56 {

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();

        Queue<Interval> list = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) {
                    return 0;
                }

                return (o1.start < o2.start) ? -1 : 1;
            }
        });

        for (Interval interval : intervals) {
            list.add(interval);
        }

        while (!list.isEmpty()) {
            Interval interval = list.poll();
            if (result.size() == 0) {
                result.add(interval);
                continue;
            }

            Interval last = result.get(result.size() - 1);
            if (interval.start <= last.end) {
                last.end = Math.max(last.end, interval.end);
            }
            else {
                result.add(interval);
            }
        }

        return result;
    }

}
