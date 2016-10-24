package leetcode.questions.dp;

/**
 Given a string s, partition s such that every substring of the partition is a palindrome.

 Return the minimum cuts needed for a palindrome partitioning of s.

 For example, given s = "aab",
 Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

 -----------------------------------------------------------------------------------------------

 Seems like longest palindrome algo can help here. We can use the longest palindrome to find all palindrome as
 we update the min number (min cut at right side of current palindrome == min cut at (left - 1) + 1

 */
public class Palindrome_Partitioning_II_132 {

    public static int minCut(String s) {
        if ((s == null) || (s.length() == 0)) {
            return 0;
        }

        char[] chrs = s.toCharArray();

        // init dp...worst would be n - 1
        int[] min = new int[chrs.length];
        for (int index = 0; index < min.length; index++) {
            min[index] = index;
        }

        // find palindrome combo
        for (int index = 0; index < chrs.length; index++) {
            findAll(min, chrs, index, index);
            if (index < chrs.length - 1) {
                findAll(min, chrs, index, index + 1);
            }
        }

        return min[chrs.length - 1];
    }

    private static void findAll(int[] min, char[] chrs, int left, int right) {
        while ((left >= 0) && (right < chrs.length)) {
            if (chrs[left] != chrs[right])
            {
                break;
            }

            // we can update min...
            int lastCut = left == 0 ? -1 : min[left - 1];
            min[right] = Math.min(min[right], lastCut + 1);

            left--;
            right++;
        }
    }

}
