package leetcode.questions.test.data_structures.binary_tree;

import leetcode.models.TreeNode;
import leetcode.questions.data_structures.binary_tree.Count_Complete_Tree_Nodes_222;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/14/2016.
 */
public class Count_Complete_Tree_Nodes_222_Test {

    @Test
    public void testSimple() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.left.left = new TreeNode(5);
        root.left.left.left.right = new TreeNode(5);
        root.left.left.right = new TreeNode(4);
        root.left.left.right.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.left.left = new TreeNode(4);
        root.right.left.right = new TreeNode(4);
        root.right.right = new TreeNode(3);
        root.right.right.left = new TreeNode(4);
        root.right.right.right = new TreeNode(4);

        assertEquals(18, Count_Complete_Tree_Nodes_222.countNodes(root));
    }

    @Test
    public void testSimple1() {
        TreeNode root = new TreeNode(1);

        assertEquals(1, Count_Complete_Tree_Nodes_222.countNodes(root));
    }

    @Test
    public void testSimple2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        assertEquals(2, Count_Complete_Tree_Nodes_222.countNodes(root));
    }

    @Test
    public void testSimple3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        assertEquals(3, Count_Complete_Tree_Nodes_222.countNodes(root));
    }

    @Test
    public void testSimple4() {
        TreeNode root = generate(500);

        assertEquals(500, Count_Complete_Tree_Nodes_222.countNodes(root));
    }

    private TreeNode generate(int number) {
        Queue<TreeNode> current = new ArrayDeque<>();

        TreeNode root = new TreeNode(1);
        current.add(root);
        int count = 1;
        while(!current.isEmpty()) {
            TreeNode node = current.poll();
            node.left = new TreeNode(1);
            current.add(node.left);
            count++;
            if (count == number) {
                break;
            }
            node.right = new TreeNode(1);
            current.add(node.right);
            count++;
            if (count == number) {
                break;
            }
        }
        return root;
    }

}
