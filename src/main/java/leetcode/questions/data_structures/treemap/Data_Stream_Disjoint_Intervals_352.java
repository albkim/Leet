package leetcode.questions.data_structures.treemap;

import leetcode.models.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**

 Given a data stream input of non-negative integers a1, a2, ..., an, ...,
 summarize the numbers seen so far as a list of disjoint intervals.

 For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ...,
 then the summary will be:
 [1, 1]
 [1, 1], [3, 3]
 [1, 1], [3, 3], [7, 7]
 [1, 3], [7, 7]
 [1, 3], [6, 7]
 Follow up: What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?


 ------------------------------------------------------------------------------------------------------------------

 Seems like we can use a treemap and look for ceiling and floor and do boundary check. The boundary should check if it overlaps
 on either side, if it does, merge it to the right side. If it connects (overlaps with both), and merge two sides

 */
public class Data_Stream_Disjoint_Intervals_352 {

    private TreeMap<Integer, Interval> map = new TreeMap<>();

    public Data_Stream_Disjoint_Intervals_352() {
    }

    public void addNum(int val) {
        if (this.map.containsKey(val)) {
            // noop
            return;
        }

        Map.Entry<Integer, Interval> left = this.map.floorEntry(val);
        Map.Entry<Integer, Interval> right = this.map.ceilingEntry(val);

        boolean merged = false;

        if (left != null) {
            // see if I can merge
            if ((val - left.getValue().end) <= 1) {
                left.getValue().end = Math.max(val, left.getValue().end);
                merged = true;
            }
        }

        if (right != null) {
            // see if I can merge
            if (right.getValue().start - val <= 1) {
                this.map.remove(right.getKey());

                right.getValue().start = val;

                // push it back
                this.map.put(right.getValue().start, right.getValue());

                merged = true;
            }
        }

        // see if i can connect
        if ((left != null) && (right != null) && (right.getValue().start - left.getValue().end <= 1)) {
            this.map.remove(right.getValue().start);

            left.getValue().end = right.getValue().end;
        }

        if (!merged) {
            this.map.put(val, new Interval(val, val));
        }
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(this.map.values());
    }

}
