package leetcode.questions.data_structures.binary_tree;

import leetcode.models.TreeNode;

/**
 Given a complete binary tree, count the number of nodes.

 Definition of a complete binary tree from Wikipedia:
 In a complete binary tree every level, except possibly the last, is completely filled,
 and all nodes in the last level are as far left as possible. It can have between
 1 and 2h nodes inclusive at the last level h.

 --------------------------------------------------------------------------------------------

 I am guessing the trick is to not iterate through all the nodes. By a complete binary tree, we know it will have
 h[0 - h-1] 2^h nodes. And then maybe do a binary search like....

                                    1
                    2                              2
            3               3               3              3
        4       4       4      4        4      4       4      4
    5       55       5

 1
 2-3
 4-7
 8-15
 16-31
 32-63
 64-127
 128-255
 256-511
 */
public class Count_Complete_Tree_Nodes_222 {

    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int height = getHeight(root, 0, true);

        int count = 0;
        int currentHeight = 1;
        TreeNode current = root;
        while(current != null) {
            // check the left sub tree
            int midHeight = getHeight(current.left, currentHeight, false);
            if (height == midHeight) {
                // add # of nodes on the left subtree leaf which is 2^(height - current height)
                int power = height - currentHeight - 1;
                if (power >= 0) {
                    count += (1 << power);
                }

                // one edge condition is that, if current height == height, then this is a full tree
                if (currentHeight == height) {
                    count++;
                }

                // this mean we still have a node here. So we want to move right
                current = current.right;
            }
            else {
                current = current.left;
            }
            currentHeight++;
        }

        for (int level = 0; level < height - 1; level++) {
            count += (1 << level);
        }

        return count;
    }

    private static int getHeight(TreeNode root, int height, boolean left) {
        while(root != null) {
            root = (left) ? root.left : root.right;
            height++;
        }
        return height;
    }

}
