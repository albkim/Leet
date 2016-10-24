package leetcode.questions.test.dp;

import leetcode.models.TreeNode;
import leetcode.questions.dp.House_Robber_III_337;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/22/2016.
 */
public class House_Robber_III_337_Test {

    @Test
    public void testSimple() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        assertEquals(7, House_Robber_III_337.rob(root));
    }

}
