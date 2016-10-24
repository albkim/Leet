package leetcode.questions.test.data_structures.binary_tree;

import leetcode.questions.data_structures.binary_tree.Verify_Preorder_Serialization_Binary_Tree_331;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/22/2016.
 */
public class Verify_Preorder_Serialization_Binary_Tree_331_Test {

    @Test
    public void testSimple() {
        assertTrue(Verify_Preorder_Serialization_Binary_Tree_331.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        assertFalse(Verify_Preorder_Serialization_Binary_Tree_331.isValidSerialization("1,#"));
        assertFalse(Verify_Preorder_Serialization_Binary_Tree_331.isValidSerialization("9,#,#,1"));
    }

}
