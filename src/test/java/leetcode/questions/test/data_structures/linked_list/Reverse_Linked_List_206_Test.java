package leetcode.questions.test.data_structures.linked_list;

import leetcode.models.ListNode;
import leetcode.questions.data_structures.linked_list.Reverse_Linked_List_206;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/12/2016.
 */
public class Reverse_Linked_List_206_Test {

    @Test
    public void testSimple() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ListNode copy = Reverse_Linked_List_206.reverseList(head);

        assertNotNull(copy);
        assertEquals(3, copy.val);
        assertEquals(2, copy.next.val);
        assertEquals(1, copy.next.next.val);
        assertNull(copy.next.next.next);
    }

}
