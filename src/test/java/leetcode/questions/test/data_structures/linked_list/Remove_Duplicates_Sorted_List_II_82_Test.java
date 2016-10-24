package leetcode.questions.test.data_structures.linked_list;

import leetcode.questions.data_structures.linked_list.Remove_Duplicates_Sorted_List_II_82;
import leetcode.models.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/21/2016.
 */
public class Remove_Duplicates_Sorted_List_II_82_Test {

    @Test
    public void testSimple() {
        ListNode input = new ListNode(1);
        input.next = new ListNode(2);
        input.next.next = new ListNode(3);
        input.next.next.next = new ListNode(3);
        input.next.next.next.next = new ListNode(4);
        input.next.next.next.next.next = new ListNode(4);
        input.next.next.next.next.next.next = new ListNode(5);

        ListNode result = Remove_Duplicates_Sorted_List_II_82.deleteDuplicates(input);

        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(5, result.next.next.val);
    }
}
