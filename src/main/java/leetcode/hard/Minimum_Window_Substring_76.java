package leetcode.hard;

import java.util.*;

/**
 Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

 For example,
 S = "ADOBECODEBANC"
 T = "ABC"


 Minimum window is "BANC".

 Note:
 If there is no such window in S that covers all characters in T, return the empty string "".

 If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.


 ------------------------------------------------------------------------------------------------------------------------

 Seems like I can do this with a single scan with a dictionary and keeping track of the following:
    minWindowStart - current shortest start
    minWindowEnd - current shortest end

    start - current start
    end - current end

    if current letter matches min of the current window, then we can advance the window, otherwise we need to ignore
    and perform the min check
 */
public class Minimum_Window_Substring_76 {

    private static class Tracker {
        public int index;
        public char chr;

        public Tracker(int index, char chr) {
            this.index = index;
            this.chr = chr;
        }
    }

    public static String minWindow(String s, String t) {
        int minWindowStart = -1;
        int minWindowEnd = -1;

        int start = -1;
        int end = -1;

        int[] lookup = new int[58];
        for (char chr : t.toCharArray()) {
            lookup[chr - 'A']++;
        }

        boolean complete = false;
        int[] tracker = new int[58];
        Queue<Tracker> positions = new ArrayDeque<>();

        for (int index = 0; index < s.length(); index++) {
            char chr = s.charAt(index);
            int chrIndex = chr - 'A';
            if (lookup[chrIndex] > 0) {
                // keep the the current char
                tracker[chrIndex]++;

                if (!complete) {
                    // see if we have a complete pattern
                    if (start == -1) {
                        start = index;
                        minWindowStart = start;
                    }

                    if (isComplete(lookup, tracker)) {
                        end = index;
                        minWindowEnd = end;
                        complete = true;
                    }
                }

                // only start comparison logic once we have everything
                if ((complete) && (positions.size() > 0)) {
                    // we have a complete pattern, now we need to see if can make the pattern shorter by removing
                    // extra chars from the left
                    while(tracker[positions.peek().chr - 'A'] > lookup[positions.peek().chr - 'A']) {
                        // it's possible that this could make the pattern shorter
                        Tracker head = positions.poll();

                        start = positions.peek().index;
                        end = index;

                        if ((end - start) < (minWindowEnd - minWindowStart)) {
                            minWindowStart = start;
                            minWindowEnd = end;
                        }

                        tracker[head.chr - 'A']--;
                    }
                }

                positions.offer(new Tracker(index, chr));
            }
        }

        if ((minWindowStart == -1) || (minWindowEnd == -1)) {
            return "";
        }

        return s.substring(minWindowStart, minWindowEnd + 1);
    }

    private static boolean isComplete(int[] lookup, int[] tracker) {
        boolean isComplete = true;

        for(int index = 0; index < lookup.length; index++) {
            if (lookup[index] > tracker[index]) {
                isComplete = false;
                break;
            }
        }

        return isComplete;
    }

}
