package leetcode.questions.data_structures.map;

import java.util.*;

/**
 Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:
 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]


 sort each word and use a map to group. Alternatively come up with order independent hash?
 */

public class Group_Anagrams_49 {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> collection = new HashMap<>();

        for (String word : strs) {
            char[] keyArray = word.toCharArray();
            Arrays.sort(keyArray);
            String key = new String(keyArray);

            List<String> group;
            if (collection.containsKey(key)) {
                group = collection.get(key);
            }
            else {
                group = new ArrayList<>();
                collection.put(key, group);
            }
            group.add(word);
        }

        return new ArrayList<>(collection.values());
    }

}
