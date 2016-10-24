package leetcode.questions.array;

/**
 Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

 Formally the function should:


 Return true if there exists i, j, k
 such that arr[i] < arr[j] < arr[k] given 0 ? i < j < k ? n-1 else return false.


 Your algorithm should run in O(n) time complexity and O(1) space complexity.

 Examples:
 Given [1, 2, 3, 4, 5],
 return true.

 Given [5, 4, 3, 2, 1],
 return false.

 -----------------------------------------------------------------------------------------------------

 I think this is just simplified lis search with fixed sized array. (3)

 */
public class Increasing_Triplet_Subsequence_334 {

    public static boolean increasingTriplet(int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return false;
        }

        int lisLength = 0;
        int[] lis = new int[3];
        for (int num : nums) {
            lisLength = miniLIS(lis, lisLength, num);
            if (lisLength == 3) {
                return true;
            }
        }
        return false;
    }

    private static int miniLIS(int[] lis, int length, int number){
        if ((length == 0) || (number > lis[length - 1])) {
            lis[length] = number;
            length++;
        }
        else {
            int replaceIndex = length - 1;
            for (int index = length - 1; index >=0; index--) {
                // find the smallest number greater than current
                if (lis[index] >= number) {
                    replaceIndex = index;
                }
            }

            lis[replaceIndex] = number;
        }

        return length;
    }

}
