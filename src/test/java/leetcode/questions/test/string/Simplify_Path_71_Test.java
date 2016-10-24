package leetcode.questions.test.string;

import leetcode.questions.string.Simplify_Path_71;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/19/2016.
 */
public class Simplify_Path_71_Test {

    @Test
    public void testEdge() {
        assertEquals("/", Simplify_Path_71.simplifyPath("/../"));
        assertEquals("/home/foo", Simplify_Path_71.simplifyPath("/home//foo/"));
    }

    @Test
    public void testSimple() {
        assertEquals("/home", Simplify_Path_71.simplifyPath("/home/"));
        assertEquals("/c", Simplify_Path_71.simplifyPath("/a/./b/../../c/"));
    }

}
