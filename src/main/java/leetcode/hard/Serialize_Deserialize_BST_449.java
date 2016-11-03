package leetcode.hard;

import leetcode.models.TreeNode;

import java.util.Stack;

/**

 Figured I'd try this out

 Should only need to store pre-order traversal
 */
public class Serialize_Deserialize_BST_449 {

    public static String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();

        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while ((current != null) || (!stack.empty())) {
            if (current != null) {
                // process current
                if (result.length() > 0) {
                    result.append(',');
                }
                result.append(String.valueOf(current.val));

                // add current to the stack
                stack.add(current);

                // move left
                current = current.left;
            }
            else {
                current = stack.pop();

                current = current.right;
            }
        }

        return result.toString();
    }

    public static TreeNode deserialize(String serialized) {
        String[] values = serialized.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(current);

        for (int index = 1; index < values.length; index++){
            int value = Integer.parseInt(values[index]);
            if (value < current.val) {
                // by definition this is immediate left
                current.left = new TreeNode(value);
                stack.add(current.left);
                current = current.left;
            }
            else {
                // now we need to find the current node where this right node belongs to.
                // as we look at the stack, we can pop off all the nodes where the value is less than this
                // the last node is the root of this node
                while ((!stack.empty()) && (stack.peek().val < value)) {
                    current = stack.pop();
                }
                current.right = new TreeNode(value);
                stack.add(current.right);
                current = current.right;
            }
        }

        return root;
    }

}
