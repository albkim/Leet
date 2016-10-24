package leetcode.questions.data_structures.linked_list;

import leetcode.models.ListNode;

/**
 Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

 Note: Do not modify the linked list.

 Follow up:
 Can you solve it without using extra space?


 --------------------------------------------------------------------------------------------------

 Once the two pointer meets, move slow to the beginning of the list and move both by 1

 a -> b -> c -> d -> b

 b, c -> c, b -> d,d -> a,d -> b,b

 */
public class Linked_List_Cycle_II_142 {

    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
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
                return null;
            }

            if (slow == fast) {
                // found cycle
                slow = head;
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }

}
