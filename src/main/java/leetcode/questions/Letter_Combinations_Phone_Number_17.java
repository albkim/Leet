package leetcode.questions;

import java.util.*;

/**
 Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.

 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

 */
public class Letter_Combinations_Phone_Number_17 {

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if ((digits == null) || (digits.length() == 0)) {
            return result;
        }

        Map<Character, List<Character>> map = new HashMap<>();
        map.put('0', Arrays.asList());
        map.put('1', Arrays.asList());
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        letterCombination(map, result, "", digits, 0);

        return result;
    }

    private static void letterCombination(Map<Character, List<Character>> map, List<String> result, String current, String digits, int index) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        for (char chr : map.get(digits.charAt(index))) {
            letterCombination(map, result, current + chr, digits, index + 1);
        }
    }

}
