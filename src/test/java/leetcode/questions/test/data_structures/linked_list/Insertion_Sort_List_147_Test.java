package leetcode.questions.test.data_structures.linked_list;

import leetcode.models.ListNode;
import leetcode.questions.data_structures.linked_list.Insertion_Sort_List_147;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/8/2016.
 */
public class Insertion_Sort_List_147_Test {

    @Test
    public void testSimple() {
        ListNode head = new ListNode(4);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(1);

        ListNode copy = Insertion_Sort_List_147.insertionSortList(head);

        assertEquals(1, copy.val);
        assertEquals(3, copy.next.val);
        assertEquals(4, copy.next.next.val);
        assertEquals(5, copy.next.next.next.val);
    }

}
