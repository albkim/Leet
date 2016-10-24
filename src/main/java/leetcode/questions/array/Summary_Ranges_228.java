package leetcode.questions.array;

import java.util.ArrayList;
import java.util.List;

/**
 Given a sorted integer array without duplicates, return the summary of its ranges.

 For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

 -------------------------------------------------------------------------------------

 As we scan left to right, we can store any ranges we find. And then it's just matter of checking the last
 and see if we can extend it or need to add a new one

 */
public class Summary_Ranges_228 {

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if ((nums == null) || (nums.length == 0)) {
            return result;
        }

        int rangeIndex = -1;
        int[][] ranges = new int[nums.length][2];

        for (int num : nums) {
            if ((rangeIndex == -1) || (ranges[rangeIndex][1] != num - 1)) {
                rangeIndex++;
                ranges[rangeIndex] = new int[] {num, num};
            }
            else {
                ranges[rangeIndex][1] = num;
            }
        }

        for (int index = 0; index <= rangeIndex; index++) {
            int[] range = ranges[index];
            if (range[0] == range[1]) {
                result.add(String.valueOf(range[0]));
            }
            else {
                result.add(String.valueOf(range[0]) + "->" + String.valueOf(range[1]));
            }
        }

        return result;
    }

}
