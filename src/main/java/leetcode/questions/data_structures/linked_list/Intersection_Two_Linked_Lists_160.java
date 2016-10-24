package leetcode.questions.data_structures.linked_list;

import leetcode.models.ListNode;

/**
 Write a program to find the node at which the intersection of two singly linked lists begins.


 For example, the following two linked lists:
 A:          a1 ? a2
                      ?
                       c1 ? c2 ? c3
                      ?
 B:     b1 ? b2 ? b3


 begin to intersect at node c1.


 Notes:
 •If the two linked lists have no intersection at all, return null.
 •The linked lists must retain their original structure after the function returns.
 •You may assume there are no cycles anywhere in the entire linked structure.
 •Your code should preferably run in O(n) time and use only O(1) memory.

 ------------------------------------------------------------------------------

 Connect one of the linked list to the end of the list. This would create a cycle. Which then can be used to determine
 the starting location.

 We can also use the traverse to the end of both list and compare two end node. If they are not the same (assuming
 intersection continues to the end), then we know there is no intersection

 */
public class Intersection_Two_Linked_Lists_160 {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if ((headA == null) || (headB == null)) {
            return null;
        }

        ListNode endA = headA;
        while(endA.next != null) {
            endA = endA.next;
        }

        ListNode endB = headB;
        while(endB.next != null) {
            endB = endB.next;
        }

        if (endA != endB) {
            return null;
        }

        endA.next = headA;

        // cannot be null since it's a cycle. We can just traverse.
        ListNode slow = headB.next;
        ListNode fast = headB.next.next;

        while(slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // we met here. Now put slow in the beginning and move one by one until they meet
        slow = headB;

        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        endA.next = null;

        return slow;
    }

}
