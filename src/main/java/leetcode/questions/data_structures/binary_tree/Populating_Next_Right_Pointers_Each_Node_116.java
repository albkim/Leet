package leetcode.questions.data_structures.binary_tree;

import leetcode.models.TreeLinkNode;

/**
 Given a binary tree

 struct TreeLinkNode {
     TreeLinkNode *left;
     TreeLinkNode *right;
     TreeLinkNode *next;
 }


 Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

 Initially, all next pointers are set to NULL.

 Note:
 •You may only use constant extra space.
 •You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).

 For example,
 Given the following perfect binary tree,

      1
    /  \
   2    3
  / \  / \
 4  5  6  7


 After calling your function, the tree should look like:

      1 -> NULL
    /  \
   2 -> 3 -> NULL
  / \  / \
 4->5->6->7 -> NULL

-------------------------------------------------------------------------------------------------

 If we don't have to use constant space, this would be easy...level order traversal...perhaps, i can use the
 tree level like a linked list :)

 */
public class Populating_Next_Right_Pointers_Each_Node_116 {

    public static void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        TreeLinkNode current = root;
        while(current != null) {
            TreeLinkNode nextHead = new TreeLinkNode(-1);

            TreeLinkNode next = nextHead;
            while (current != null) {
                if (current.left != null) {
                    next.next = current.left;
                    next = next.next;
                }
                if (current.right != null) {
                    next.next = current.right;
                    next = next.next;
                }

                current = current.next;
            }

            current = nextHead.next;
        }
    }

}
