package leetcode.questions.data_structures.linked_list;

import leetcode.models.ListNode;

/**
 Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 ≤ m ≤ n ≤ length of list.


 -------------------------------------------------------------------------------------

 Iterative reverse linked list problem with extra tracking


 */
public class Reverse_Linked_List_II_92 {

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if ((head == null) || (head.next == null) || (m < 1) || (n < 1)) {
            return head;
        }

        // left should hold the node before the range
        ListNode left;
        if (m == 1) {
            left = new ListNode(-1);
            left.next = head;
        }
        else {
            left = head;
        }

        // m = 1 -> fake head, m = 2 -> head, m = 3 -> 2nd
        for (int count = 1; count < m - 1; count++) {
            left = left.next;
        }

        ListNode previous = null;
        ListNode current = left.next;
        // iteratively reverse nodes till n
        for (int count = m; count <= n; count++) {
            // hold on to next
            ListNode next = current.next;

            // swap next with previous and then keep current as previous
            current.next = previous;
            previous = current;

            // set current to next
            current = next;
        }

        // now, we have left, reversed linked list, and next
        left.next.next = current;
        left.next = previous;

        return (m == 1) ? left.next : head;
    }

}
