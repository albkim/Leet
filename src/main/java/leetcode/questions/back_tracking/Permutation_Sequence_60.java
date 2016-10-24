package leetcode.questions.back_tracking;

import java.util.ArrayList;
import java.util.List;

/**
 The set [1,2,3,…,n] contains a total of n! unique permutations.

 By listing and labeling all of the permutations in order,
 We get the following sequence (ie, for n = 3):
 1."123"
 2."132"
 3."213"
 4."231"
 5."312"
 6."321"


 Given n and k, return the kth permutation sequence.

 Note: Given n will be between 1 and 9 inclusive.


 ------------------------------------------------------------------------------------------------------------

 Permutation of numbers always has fixed number of permutations
 n = 1 -> 1
 n = 2 -> 1,2 & 2,1 -> 2
 n = 3 -> 6
    1 + (2,3)
    2 + (1,3)
    3 + (1,2)
 n = 4 -> 24
    1 + (2,3,4)
    2 + (1,3,4)
    3 + (1,2,4)
    4 + (1,2,3)

 If we were to try to get all possible permutation it would be too slow. We can programatically get the current one
 based on the pattern above
 */
public class Permutation_Sequence_60 {

    public static String getPermutation(int n, int k) {
        // we now have total number of permutation lookup for every number up to n
        int[] lookup = new int[n];
        lookup[0] = 1;
        for (int number = 1; number < n; number++) {
            lookup[number] = lookup[number - 1] * (number);
        }

        return getPermutation(lookup, new boolean[n], new ArrayList<>(), n, k);
    }

    private static String getPermutation(int[] lookup, boolean[] used, List<Integer> current, int n, int k) {
        if (current.size() == n){
            StringBuilder result = new StringBuilder();
            for(int number : current) {
                result.append(number);
            }
            return result.toString();
        }

        int index = 0;
        int permutations = lookup[n - current.size() - 1];
        int targetIndex = (k - 1) / permutations;
        for (int number = 1; number <= n; number++) {
            if (!used[number - 1]) {
                if (targetIndex == index) {
                    used[number - 1] = true;
                    current.add(number);
                    int subK = k - (targetIndex * permutations);
                    return getPermutation(lookup, used, current, n, subK);
                }
                index++;
            }
        }

        return "";
    }

}
