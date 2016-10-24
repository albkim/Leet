package leetcode.questions.string;

import java.util.Arrays;
import java.util.Comparator;

/**
 Given a list of non negative integers, arrange them such that they form the largest number.

 For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

 Note: The result may be very large, so you need to return a string instead of an integer.


 ------------------------------------------------------------------------------

 Seems like it's a variation of lexical soft. Once we hit the same starting numbers, we have to compare them differently...
 36, 3 & 31, 3 & 3331, 3 ....greatest is 363 and 331 and 33331

 1234, 123 = 123412
 2341, 234 = 2342341

 123123124, 123 =
 Once we find that one is a subsequence of another, we need to find the first non match and then compare it against

 */
public class Largest_Number_179 {

    public static String largestNumber(int[] nums) {
        String[] sNums = new String[nums.length];

        int numberOfZeroes = 0;
        for (int index = 0; index < nums.length; index++) {
            sNums[index] = String.valueOf(nums[index]);
            if (nums[index] == 0) {
                numberOfZeroes++;
            }
        }

        // not sure how i can do this other than this special case
        if (numberOfZeroes == nums.length) {
            return "0";
        }

        Arrays.sort(sNums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                // only edge case is one is a subsequence of another
                boolean isSubsequence = false;
                if (o1.length() != o2.length()) {
                    int countSame = 0;
                    int minLength = Math.min(o1.length(), o2.length());
                    for (int index = 0; index < minLength; index++) {
                        if (o1.charAt(index) == o2.charAt(index)) {
                            countSame++;
                        }
                    }
                    isSubsequence = countSame == minLength;
                }

                if (isSubsequence) {
                    // replace instance of subsequence from prefix and recursively call for smaller pieces
                    if (o1.length() > o2.length()) {
                        o1 = o1.substring(o2.length());
                    }
                    else {
                        o2 = o2.substring(o1.length());
                    }

                    return compare(o1, o2);
                }

                // simple descending lexical order
                return o2.compareTo(o1);
            }
        });

        StringBuilder result = new StringBuilder();
        for (String sNum : sNums) {
            result.append(sNum);
        }
        return result.toString();
    }

}
