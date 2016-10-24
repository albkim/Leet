package leetcode.questions.data_structures.map;

import java.util.HashMap;
import java.util.Map;

/**
 *
 Given  an  arbitrary  ransom  note  string  and  another  string  containing  letters from  all  the  magazines, 
 write  a  function  that  will  return  true  if  the  ransom  note  can  be  constructed  from  the  magazines;
  otherwise,  it  will  return  false.   
 Each  letter  in  the  magazine  string  can  only  be  used  once  in  your  ransom  note.

 Note: You may assume that both strings contain only lowercase letters.
 canConstruct("a", "b") -> false
 canConstruct("aa", "ab") -> false
 canConstruct("aa", "aab") -> true

 */
public class Ransom_Note_383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        if ((ransomNote == null) || (magazine == null)) {
            throw new IllegalArgumentException("Input null");
        }

        Map<Character, Integer> lookup = new HashMap<>();
        for(char ch : magazine.toCharArray()) {
            if (lookup.containsKey(ch)) {
                lookup.put(ch, lookup.get(ch) + 1);
            }
            else {
                lookup.put(ch, 1);
            }
        }

        for (char ch : ransomNote.toCharArray()) {
            if (!lookup.containsKey(ch)) {
                return false;
            }
            int remaining = lookup.get(ch);
            if (remaining < 1) {
                return false;
            }
            lookup.put(ch, remaining - 1);
        }

        return true;
    }

}
