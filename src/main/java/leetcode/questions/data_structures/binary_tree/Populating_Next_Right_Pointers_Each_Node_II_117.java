package leetcode.questions.data_structures.binary_tree;

import leetcode.models.TreeLinkNode;

/**
 Follow up for problem "Populating Next Right Pointers in Each Node".

 What if the given tree could be any binary tree? Would your previous solution still work?

 Note:
 •You may only use constant extra space.

 For example,
 Given the following binary tree,

      1
    /  \
   2    3
  / \    \
 4   5    7



 After calling your function, the tree should look like:

     1 -> NULL
    /  \
   2 -> 3 -> NULL
  / \    \
 4-> 5 -> 7 -> NULL

--------------------------------------------------------------------------------------------------------

 Seems like careful check is all is needed

 */
public class Populating_Next_Right_Pointers_Each_Node_II_117 {

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
