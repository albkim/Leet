package leetcode.questions.data_structures.binary_tree;

import java.util.StringTokenizer;

/**
 One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node,
 we record the node's value. If it is a null node, we record using a sentinel value such as #.
      _9_
     /   \
    3     2
   / \   / \
  4   1  #  6
 / \ / \   / \
 # # # #   # #


 For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#",
 where # represents a null node.

 Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree.
 Find an algorithm without reconstructing the tree.

 Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

 You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

 Example 1:
 "9,3,4,#,#,1,#,#,2,#,6,#,#"
 Return true

 Example 2:
 "1,#"
 Return false

 Example 3:
 "9,#,#,1"
 Return false

 -----------------------------------------------------------------------------------------------------

 It seems like there are two cases:
    we have an incomplete node - we will run out of token before populating children
    parent is null - we will have chars left over in the tokenizer

 */
public class Verify_Preorder_Serialization_Binary_Tree_331 {

    public static boolean isValidSerialization(String preorder) {
        StringTokenizer tokenizer = new StringTokenizer(preorder, ",");

        return validate(tokenizer) && !tokenizer.hasMoreTokens();
    }

    private static boolean validate(StringTokenizer tokenizer) {
        String value = tokenizer.nextToken();

        if (value.equals("#")) {
            return true;
        }

        if (!tokenizer.hasMoreTokens()) {
            return false;
        }
        boolean left = validate(tokenizer);
        if (!tokenizer.hasMoreTokens()) {
            return false;
        }
        boolean right = validate(tokenizer);

        return left & right;
    }

}
