package leetcode.questions.test.data_structures.linked_list;

import leetcode.questions.data_structures.linked_list.Remove_Duplicates_Sorted_List_83;
import leetcode.models.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/21/2016.
 */
public class Remove_Duplicates_Sorted_List_83_Test {

    @Test
    public void testSimple() {
        ListNode input = new ListNode(1);
        input.next = new ListNode(1);
        input.next.next = new ListNode(2);

        ListNode result = Remove_Duplicates_Sorted_List_83.deleteDuplicates(input);

        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertNull(result.next.next);
    }

    @Test
    public void testMultiple() {
        ListNode input = new ListNode(1);
        input.next = new ListNode(1);
        input.next.next = new ListNode(2);
        input.next.next.next = new ListNode(3);
        input.next.next.next.next = new ListNode(3);

        ListNode result = Remove_Duplicates_Sorted_List_83.deleteDuplicates(input);

        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(3, result.next.next.val);
        assertNull(result.next.next.next);
    }

}
