package leetcode.questions.back_tracking;

import java.util.ArrayList;
import java.util.List;

/**
 Given a string containing only digits, restore it by returning all possible valid IP address combinations.

 For example:
 Given "25525511135",

 return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

 ------------------------------------------------------------------------------------------------------------

 It seems like we can follow some basic rules and use back tracking to generate valid ip addresses

    should be max 3 digits (0 -> 255) with 4 "."

 */
public class Restore_IP_Addresses_93 {

    public static List<String> restoreIpAddresses(String s) {
        // perform basic checks
        List<String> result = new ArrayList<>();
        if ((s == null) || (s.length() < 4) || (s.length() > 12)) {
            return result;
        }

        backtrack(result, new ArrayList<String>(), s, 0);

        return result;
    }

    private static void backtrack(List<String> result, ArrayList<String> strings, String s, int index) {
        // base condition
        if ((strings.size() == 4) && (index == s.length())) {
            // now this is a valid ip address
            StringBuilder ip = new StringBuilder();
            for (String part : strings) {
                if (ip.length() > 0) {
                    ip.append('.');
                }
                ip.append(part);
            }
            result.add(ip.toString());
        }

        // variations
        for (int scan = index; scan < Math.min(index + 3, s.length()); scan++) {
            String part = s.substring(index, scan + 1);

            if (validIPPart(part)) {
                strings.add(part);
            }
            else {
                continue;
            }

            backtrack(result, strings, s, scan + 1);

            strings.remove(strings.size() - 1);
        }
    }

    private static boolean validIPPart(String s) {
        int part = Integer.parseInt(s);

        if (part <= 255) {
            // cannot be 001 or 00 or etc.
            return String.valueOf(part).equals(s);
        }

        return false;
    }


}
