package leetcode.questions.data_structures.binary_tree;

import leetcode.models.TreeNode;

import java.util.Stack;

/**
 Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

 Calling next() will return the next smallest number in the BST.

 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

 ----------------------------------------------------------------------------------------------------

 Pretty similar to in order iterative traversal

 */
public class Binary_Search_Tree_Iterator_173 {

    private Stack<TreeNode> stack;
    private TreeNode current;

    public Binary_Search_Tree_Iterator_173(TreeNode root) {
        this.stack = new Stack<>();
        this.current = root;

        this.traverseToNext();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty();
    }

    /** @return the next smallest number */
    public int next() {
        if (stack.isEmpty()) {
            return -1;
        }

        this.current = stack.pop();

        int value = current.val;

        this.current = this.current.right;
        this.traverseToNext();

        return value;
    }

    private void traverseToNext() {
        while (this.current != null) {
            this.stack.add(current);
            this.current = current.left;
        }
    }

}
