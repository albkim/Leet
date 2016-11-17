package leetcode.questions.sorting;

import java.util.*;

/**
 Given a string, sort it in decreasing order based on the frequency of characters.

 Example 1:
 Input:
 "tree"

 Output:
 "eert"

 Explanation:
 'e' appears twice while 'r' and 't' both appear once.
 So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

 Example 2:
 Input:
 "cccaaa"

 Output:
 "cccaaa"

 Explanation:
 Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 Note that "cacaca" is incorrect, as the same characters must be together.

 Example 3:
 Input:
 "Aabb"

 Output:
 "bbAa"

 Explanation:
 "bbaA" is also a valid answer, but "Aabb" is incorrect.
 Note that 'A' and 'a' are treated as two different characters.

 -------------------------------------------------------------------------------------------------------------

 Seems like a classic bucket sort
 Since we need to support case sensitivity, use an array and then assign each char to bucket of count. Then reconstruct it
 based on the count

 */
public class Sort_Characters_By_Frequency_451 {

    public static String frequencySort(String s) {
        if ((s == null) || (s.length() == 0)) {
            return s;
        }

        // perform counts
        int maxCount = 0;
        int[] counts = new int[256];
        for (char chr : s.toCharArray()) {
            counts[chr]++;
            maxCount = Math.max(maxCount, counts[chr]);
        }

        // bucket by counts
        List<List<Character>> buckets = new ArrayList<>(maxCount + 1);
        for (int count = 0; count <= maxCount; count++) {
            buckets.add(new ArrayList<>());
        }

        // populate bucket
        for (int ascii = 0; ascii < counts.length; ascii++) {
            if (counts[ascii] > 0) {
                char chr = (char)(ascii);
                buckets.get(counts[ascii]).add(chr);
            }
        }

        // construct the result in desc way
        StringBuilder result = new StringBuilder();
        for (int count = buckets.size() - 1; count > 0; count--) {
            for (char chr : buckets.get(count)) {
                for (int repeat = 0; repeat < count; repeat++) {
                    result.append(chr);
                }
            }
        }
        return result.toString();
    }

}
