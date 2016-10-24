package leetcode.questions.data_structures.binary_tree;

import leetcode.models.TreeNode;

import java.util.StringTokenizer;

/**
 Serialization is the process of converting a data structure or object into a sequence of bits so that it can be
 stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later
 in the same or another computer environment.

 Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
 serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be
 serialized to a string and this string can be deserialized to the original tree structure.

 For example, you may serialize the following tree
     1
    / \
   2   3
      / \
     4   5

 as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily
 need to follow this format, so please be creative and come up with different approaches yourself.

 ------------------------------------------------------------------------------------------------------------

 If BST, we only need pre-order or post-order
 Typical way of doing this is to store both in-order and pre-order. However, if we are able to add marker for null node
 we just need one. We can do pre order.

 */
public class Serialize_Deserialize_Binary_Tree_297 {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "# ";
        }

        StringBuilder result = new StringBuilder();
        serialize(result, root);
        return result.toString();
    }

    private static void serialize(StringBuilder result, TreeNode node) {
        if (node == null) {
            result.append("# ");
            return;
        }

        result.append(node.val + " ");
        serialize(result, node.left);
        serialize(result, node.right);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }

        StringTokenizer tokenizer = new StringTokenizer(data);
        return deserialize(tokenizer);
    }

    private static TreeNode deserialize(StringTokenizer tokenizer) {
        if (!tokenizer.hasMoreTokens()) {
            return null;
        }

        String value = tokenizer.nextToken();
        if (value.equals("#")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = deserialize(tokenizer);
        node.right = deserialize(tokenizer);
        return node;
    }

}
