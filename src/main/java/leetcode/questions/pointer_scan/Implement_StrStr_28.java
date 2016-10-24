package leetcode.questions.pointer_scan;

import java.util.HashMap;
import java.util.Map;

/**
 Implement strStr().

 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 Boyer algorithm, look at the end of the needle against haystack position. Compare left...if no match is found, transpose
 needle to the next possible match and repeat

 abac
 acefhksacjhksj
     abac
      abac
 */
public class Implement_StrStr_28 {

    public static int strStr(String haystack, String needle) {
        // just not valid

        if (needle.length() == 0) {
            return 0;
        }

        if (needle.length() > haystack.length()) {
            return -1;
        }

        // create a map, only need the last indexes since if it doesn't match we can skip to the end
        Map<Character, Integer> lookup = new HashMap<>();
        for(int index = needle.length() - 2; index >= 0; index--) {
            char chr = needle.charAt(index);
            if (!lookup.containsKey(chr)) {
                lookup.put(chr, index);
            }
        }

        // very first possible position is at haystack index of needle length. Try it there.
        int pointer = needle.length() - 1;
        while(pointer < haystack.length()) {
            if (needle.charAt(needle.length() - 1) == haystack.charAt(pointer)) {
                // interesting, now try to compare down
                boolean match = true;
                for (int index = needle.length() - 2; index >= 0; index--) {
                    int haystackIndex = pointer - (needle.length() - 1 - index);
                    if (needle.charAt(index) != haystack.charAt(haystackIndex)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    return pointer - (needle.length() - 1);
                }
            }

            // find the next candidate
            if (lookup.containsKey(haystack.charAt(pointer))) {
                // only if current char is within the needle, we could have a possible match
                pointer += needle.length() - 1 - lookup.get(haystack.charAt(pointer));
            }
            else {
                // advance to next possible position
                pointer += needle.length();
            }
        }

        return -1;
    }

}
