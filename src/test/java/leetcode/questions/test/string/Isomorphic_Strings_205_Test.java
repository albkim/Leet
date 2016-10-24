package leetcode.questions.test.string;

import leetcode.questions.string.Isomorphic_Strings_205;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/12/2016.
 */
public class Isomorphic_Strings_205_Test {

    @Test
    public void testSimple() {
        assertFalse(Isomorphic_Strings_205.isIsomorphic("ab", "aa"));
        assertTrue(Isomorphic_Strings_205.isIsomorphic("egg", "add"));
        assertFalse(Isomorphic_Strings_205.isIsomorphic("foo", "bar"));
        assertTrue(Isomorphic_Strings_205.isIsomorphic("paper", "title"));
    }

}
