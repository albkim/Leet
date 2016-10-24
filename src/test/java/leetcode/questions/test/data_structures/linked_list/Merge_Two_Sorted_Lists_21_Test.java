package leetcode.questions.test.data_structures.linked_list;

import leetcode.questions.data_structures.linked_list.Merge_Two_Sorted_Lists_21;
import leetcode.models.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/5/2016.
 */
public class Merge_Two_Sorted_Lists_21_Test {

    @Test
    public void testEdge1() {
        assertEquals(1, Merge_Two_Sorted_Lists_21.mergeTwoLists(new ListNode(1), null).val);
    }

    @Test
    public void testSimple() {
        ListNode left = new ListNode(1);
        ListNode right = new ListNode(2);
        right.next = new ListNode(3);

        ListNode result = Merge_Two_Sorted_Lists_21.mergeTwoLists(left, right);
        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(3, result.next.next.val);
    }

}
