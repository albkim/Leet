package leetcode.questions.data_structures.linked_list;

import leetcode.models.ListNode;

/**
 Given a singly linked list L: L0?L1?…?Ln-1?Ln,
 reorder it to: L0?Ln?L1?Ln-1?L2?Ln-2?…

 You must do this in-place without altering the nodes' values.

 For example,
 Given {1,2,3,4}, reorder it to {1,4,2,3}.

 ---------------------------------------------------------------------

 This is similar to reversing linked list, we just want to do it half way and then interweave

 */
public class Reorder_List_142 {

    public static void reorderList(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return;
        }

        // first find the half way point
        ListNode previous = null;
        ListNode half = head;
        ListNode end = head;
        while ((half != null) && (end != null)) {
            previous = half;
            half = half.next;
            end = end.next;
            if (end != null) {
                end = end.next;
            }
        }

        // wipe this link, otherwise we cause a cycle.
        previous.next = null;

        // now half at half way point and end at the end
        // reverse from half to end and then interweave
        previous = null;
        // hold next as current.next
        // current.next = previous
        // previous = current
        // now current = next
        while(half != null) {
            ListNode next = half.next;
            half.next = previous;
            previous = half;
            half = next;
        }

        // now half should be null and previous should be the old end which can be used to begin the interweave
        while (head != null) {
            ListNode firstNext = head.next;

            head.next = previous;
            if ((previous != null) && (previous != firstNext)) {
                // no cycles
                // previous should always be shorter
                ListNode secondNext = previous.next;
                previous.next = firstNext;
                previous = secondNext;
            }

            head = firstNext;
        }
    }

}
