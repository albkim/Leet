package leetcode.questions.test.data_structures.linked_list;

import leetcode.models.ListNode;
import leetcode.questions.data_structures.linked_list.Delete_Node_Linked_List_237;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Sang on 10/15/2016.
 */
public class Delete_Node_Linked_List_237_Test {

    @Test
    public void testSimple() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        Delete_Node_Linked_List_237.deleteNode(head.next.next);

        assertEquals(1, head.val);
        assertEquals(2, head.next.val);
        assertEquals(4, head.next.next.val);
        assertNull(head.next.next.next);
    }

}
