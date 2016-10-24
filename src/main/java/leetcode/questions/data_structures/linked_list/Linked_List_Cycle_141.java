package leetcode.questions.data_structures.linked_list;

import leetcode.models.ListNode;

/**
 Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space?

 -----------------------------------------------------------------------------------------------------

 two pointer traversal with 2nd one being faster
 */
public class Linked_List_Cycle_141 {

    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while ((slow != null) && (fast != null)) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            else {
                // important null == null is true...in case
                return false;
            }

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

}
