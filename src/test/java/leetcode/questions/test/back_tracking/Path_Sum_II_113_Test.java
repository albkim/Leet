package leetcode.questions.test.back_tracking;

import leetcode.questions.back_tracking.Path_Sum_II_113;
import leetcode.models.TreeNode;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/2/2016.
 */
public class Path_Sum_II_113_Test {

    @Test
    public void testEdge() {
        assertEquals(0, Path_Sum_II_113.pathSum(null, 0).size());
        assertEquals(0, Path_Sum_II_113.pathSum(null, 1).size());
    }

    @Test
    public void testSimple() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        List<List<Integer>> result = Path_Sum_II_113.pathSum(root, 22);

        assertEquals(2, result.size());

        assertEquals(5, result.get(0).get(0).intValue());
        assertEquals(4, result.get(0).get(1).intValue());
        assertEquals(11, result.get(0).get(2).intValue());
        assertEquals(2, result.get(0).get(3).intValue());

        assertEquals(5, result.get(1).get(0).intValue());
        assertEquals(8, result.get(1).get(1).intValue());
        assertEquals(4, result.get(1).get(2).intValue());
        assertEquals(5, result.get(1).get(3).intValue());
    }

}
