package leetcode.questions.data_structures.linked_list;

import leetcode.models.ListNode;

/**
 Sort a linked list using insertion sort.
 */
public class Insertion_Sort_List_147 {

    public static ListNode insertionSortList(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return head;
        }

        ListNode anchor = new ListNode(-1);

        ListNode newHead = anchor;

        while (head != null) {
            ListNode previous = null;
            ListNode current = head;
            ListNode smallest = head;

            while (current != null) {
                // find the smallest
                if ((current.next != null) && (current.next.val < smallest.val)) {
                    previous = current;
                    smallest = current.next;
                }

                current = current.next;
            }

            if (previous == null) {
                // head is the smallest
                head = smallest.next;
            }
            else {
                previous.next = smallest.next;
            }
            smallest.next = null;
            newHead.next = smallest;
            newHead = smallest;
        }

        return anchor.next;
    }

}
