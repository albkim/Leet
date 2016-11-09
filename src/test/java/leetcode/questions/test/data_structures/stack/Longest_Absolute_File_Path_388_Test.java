package leetcode.questions.test.data_structures.stack;

import leetcode.questions.data_structures.stack.Longest_Absolute_File_Path_388;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 11/8/2016.
 */
public class Longest_Absolute_File_Path_388_Test {

    @Test
    public void testSimple() {
        assertEquals(32, Longest_Absolute_File_Path_388.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }

}
