package leetcode.questions.data_structures.binary_search_tree;

import leetcode.models.ListNode;
import leetcode.models.TreeNode;

/**
 Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

 -------------------------------------------------------------------------------------------------------------

 n log(n) complexity would involve having two pointers, one twice as faster. When that pointer reaches the end
 the other would be at the midpoint. Then it's matter of separating the list and then passing it recursively

 */
public class Convert_Sorted_List_Binary_Search_Tree_109 {

    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode previous = head;
        ListNode median = head;
        ListNode end = head;

        if (head.next != null) {
            while (end != null) {
                end = end.next;
                if (end != null) {
                    end = end.next;
                }
                else {
                    break;
                }
                previous = median;
                median = median.next;
            }
        }

        TreeNode root = new TreeNode(median.val);

        if (head != median) {
            previous.next = null;
            root.left = sortedListToBST(head);
        }
        if (median.next != null) {
            root.right = sortedListToBST(median.next);
        }

        return root;
    }

}
