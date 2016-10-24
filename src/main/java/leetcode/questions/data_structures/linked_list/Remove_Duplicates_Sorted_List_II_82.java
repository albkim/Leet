package leetcode.questions.data_structures.linked_list;

import leetcode.models.ListNode;

/*

 Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.



 Subscribe to see which companies asked this question


 ----------------------------------------------------------------------------------------------------------------

 Seems like a simple scan with two pointers

 */
public class Remove_Duplicates_Sorted_List_II_82 {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        ListNode newHead = new ListNode(-1);
        ListNode previous = newHead;

        while(current != null) {
            int val = current.val;

            boolean dupe = false;
            ListNode next = current.next;
            while(next != null && next.val == val) {
                next = next.next;
                dupe = true;
            }

            if (dupe) {
                current = next;
            }
            else {
                // clean up current since we already have ref to next
                current.next = null;

                previous.next = current;
                previous = current;
                current = next;
            }
        }

        return newHead.next;
    }

}
