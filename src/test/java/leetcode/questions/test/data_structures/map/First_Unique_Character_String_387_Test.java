package leetcode.questions.test.data_structures.map;

import leetcode.questions.data_structures.map.First_Unique_Character_String_387;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 11/8/2016.
 */
public class First_Unique_Character_String_387_Test {

    @Test
    public void testSimple() {
        assertEquals(0, First_Unique_Character_String_387.firstUniqChar("leetcode"));
    }

    @Test
    public void testSimple1() {
        assertEquals(2, First_Unique_Character_String_387.firstUniqChar("loveleetcode"));
    }

}
