package leetcode.questions.test.dp;

import leetcode.questions.dp.Palindrome_Partitioning_II_132;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/5/2016.
 */
public class Palindrome_Partitioning_II_132_Test {

    @Test
    public void testSimple() {
        assertEquals(1, Palindrome_Partitioning_II_132.minCut("aab"));
    }

    @Test
    public void testComplex() {
        assertEquals(1, Palindrome_Partitioning_II_132.minCut("abcccb"));
    }

    @Test
    public void testComplex2() {
        assertEquals(3, Palindrome_Partitioning_II_132.minCut("ccaacabacb"));
    }

    @Test
    public void testSlow() {
        assertEquals(0, Palindrome_Partitioning_II_132.minCut("ababababababababababababcbabababababababababababa"));
    }

    @Test
    public void testSlow2() {
        assertEquals(452, Palindrome_Partitioning_II_132.minCut("apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp"));
    }

}
