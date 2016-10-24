package leetcode.questions.dp;

/**
 Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

 Below is one possible representation of s1 = "great":
 great
 /    \
 gr    eat
 / \    /  \
 g   r  e   at
             / \
             a   t


 To scramble the string, we may choose any non-leaf node and swap its two children.

 For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 rgeat
 /    \
 rg    eat
 / \    /  \
 r   g  e   at
             / \
             a   t


 We say that "rgeat" is a scrambled string of "great".

 Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 rgtae
 /    \
 rg    tae
 / \    /  \
 r   g  ta  e
         / \
         t   a


 We say that "rgtae" is a scrambled string of "great".

 Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.

 ---------------------------------------------------------------------------------------------------------------

 Isn't this pretty much anagram question...

 It is not..."abcd" "bdac"...the only way this would happen is
 ab cd -> ba dc -> now the middle part has to swap...but that requires 3 pieces

 What if we do something similar to break word and see if it yields the scrambled string

 as we scan the string from left to right, try to divide it in two and see if it's a scramble.
 The scramble would mean either of the following:
    two same sections are scramble s1(:i) == s2(:i) and s1(i:) == s2(i:) (no scramble)
    two opposite sections are scramble (rotated) s1(:i) == s2(i:) and s1(i:) == s2(:i)


 */
public class Scramble_String_87 {

    public static boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            //don't even need
            return false;
        }

        return dp(s1, s2);
        // return recurse(s1, s2, 0, 0, s1.length());
    }

    private static boolean dp(String s1, String s2) {
        boolean[][][] dp = new boolean[s1.length()][s1.length()][s2.length()];

        for (int length = 0; length < s1.length(); length++) {
            for (int left1 = 0; left1 < s1.length() - length; left1++) {
                for (int left2 = 0; left2 < s2.length() - length; left2++) {
                    if (length == 0) {
                        dp[length][left1][left2] = s1.charAt(left1) == s2.charAt(left2);
                    }
                    else {
                        for (int subLength = 0; subLength < length; subLength++) {
                            boolean notRotated = dp[subLength][left1][left2] && dp[length - subLength - 1][left1 + subLength + 1][left2 + subLength + 1];
                            boolean rotated = dp[subLength][left1][left2 + length - subLength] && dp[length - subLength - 1][left1 + subLength + 1][left2];
                            dp[length][left1][left2] = notRotated || rotated;
                            if (dp[length][left1][left2]) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return dp[s1.length() - 1][0][0];
    }

    /*
            me              em
           m   e    or     e   m
     */
    private static boolean recurse(String s1, String s2, int start1, int start2, int length) {
        // perform simple equal check, then no need to go deeper for variation
        int[] check = new int[60];
        for (int index = start1; index < start1 + length; index++) {
            check[s1.charAt(index) - 'a']++;
        }
        for (int index = start2; index < start2 + length; index++) {
            check[s2.charAt(index) - 'a']--;
        }
        for (int index = 0; index < check.length; index++) {
            if (check[index] != 0) {
                return false;
            }
        }

        // base condition
        if (length <= 1) {
            return true;
        }

        // try various parts of the string scanning from left to right
        for (int subLength = 1; subLength < length; subLength++) {
            int right1 = start1 + subLength;
            int right2 = start2 + subLength;

            // not rotated
            if ((recurse(s1, s2, start1, start2, subLength)) && (recurse(s1, s2, right1, right2, length - subLength))) {
                return true;
            }

            // rotated
            if ((recurse(s1, s2, start1, start2 + length - subLength, subLength)) && (recurse(s1, s2, right1, start2, length - subLength))) {
                return true;
            }
        }

        return false;
    }

}
