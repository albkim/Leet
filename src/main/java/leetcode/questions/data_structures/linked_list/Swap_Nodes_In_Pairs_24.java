package leetcode.questions.data_structures.linked_list;

import leetcode.models.ListNode;

/**
 Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

 */
public class Swap_Nodes_In_Pairs_24 {

    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode current = head;
        head = head.next;

        ListNode next = current.next;
        if (next != null) {
            ListNode temp = swapPairs(next.next);

            next.next = current;
            current.next = temp;
        }

        return head;
    }

}
