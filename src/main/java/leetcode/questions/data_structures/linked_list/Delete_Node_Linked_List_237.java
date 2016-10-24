package leetcode.questions.data_structures.linked_list;

import leetcode.models.ListNode;

/**
 Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

 Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,
 the linked list should become 1 -> 2 -> 4 after calling your function.

 --------------------------------------------------------------------------------------------------------

 funky value trick, copy the value from the next and delete the last node. Not entirely sure how this would
 work if node passed in is the last node. Let's assume it is not for now.

 */
public class Delete_Node_Linked_List_237 {

    public static void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }

        ListNode secondPrevious = null;
        ListNode previous = null;
        ListNode current = node;
        while(current != null) {
            if (current.next != null) {
                current.val = current.next.val;
            }
            secondPrevious = previous;
            previous = current;
            current = current.next;
        }

        secondPrevious.next = null;
    }

}
