package leetcode.questions.data_structures.binary_search_tree;

import leetcode.models.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 Two elements of a binary search tree (BST) are swapped by mistake.

 Recover the tree without changing its structure.
 Note:
 A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

 --------------------------------------------------------------------------------------------------------


 If we do in order traversal of BST, we can see ordered list of numbers. Then it's matter of finding the two numbers
 which swap

 1, 2, 3, 5, 4, 6, 7 => 5, 4
 7, 2, 3, 4, 5, 6, 1 => 1, 7
 1, 2, 5, 4, 3, 6, 7 => 5, 3


 */
public class Recover_Binary_Search_Tree_99 {

    private static class Tracker {
        public TreeNode previous;
        public List<TreeNode> badNodes = new ArrayList<>();
    };

    public static void recoverTree(TreeNode root) {
        recoverTreeRecursion(root);
    }

    private static void recoverTreeRecursion(TreeNode root) {
        Tracker tracker = new Tracker();

        findOutOfOrderBST(root, tracker);

        if (tracker.badNodes.size() == 1) {
            // the algo doesn't catch adjacent switches...need to scan again
            tracker.previous = null;
            findOutOfOrderBST(root, tracker);
        }

        if (tracker.badNodes.size() == 2) {
            // found a solution, swap and clean up the result so it doesn't continue to swap
            int tmp = tracker.badNodes.get(0).val;
            tracker.badNodes.get(0).val = tracker.badNodes.get(1).val;
            tracker.badNodes.get(1).val = tmp;
        }
    }

    private static void findOutOfOrderBST(TreeNode root, Tracker tracker) {
        if (root == null) {
            return;
        }

        findOutOfOrderBST(root.left, tracker);

        // find the out of order elements
        if ((tracker.previous != null) && (tracker.previous.val > root.val)) {
            if (tracker.badNodes.size() == 0) {
                tracker.badNodes.add(tracker.previous);
            }
            else {
                tracker.badNodes.add(root);
            }
        }

        tracker.previous = root;

        findOutOfOrderBST(root.right, tracker);
    }

    private static void findOutOfOrderMorrisTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode current = root;
        TreeNode previous;
        List<TreeNode> badNodes = new ArrayList<>();

        while(current != null) {
            if (current.left == null) {
                // perform action on current
                current = current.right;
            }
            else {
                // find the in order predecessor of the current which is the right most element in the subtree
                previous = current.left;
                // previous.right != current check is important since it checks if the thread is already established
                while(previous.right != null && previous.right != current) {
                    previous = previous.right;
                }

                if (previous.right == null) {
                    // we found the previous in order predecessor, now thread it
                    previous.right = current;
                    // now we can move on to the left;
                    current = current.left;
                }
                else {
                    // we already have this threaded, unthread it
                    previous.right = null;
                    // do something with current
                    current = current.right;
                }
            }
        }
    }

}
