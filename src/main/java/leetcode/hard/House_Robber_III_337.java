package leetcode.hard;

import leetcode.models.TreeNode;

/**
 The thief has found himself a new place for his thievery again. There is only one entrance to this area,
 called the "root." Besides the root, each house has one and only one parent house. After a tour,
 the smart thief realized that "all houses in this place forms a binary tree". It will automatically
 contact the police if two directly-linked houses were broken into on the same night.

 Determine the maximum amount of money the thief can rob tonight without alerting the police.

 Example 1:

     3 <-
    / \
   2   3
    \   \
     3<- 1<-

 Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

 Example 2:

       3
      / \
     4<- 5<-
    / \   \
   1   3   1

 Maximum amount of money the thief can rob = 4 + 5 = 9.

 --------------------------------------------------------------------------------------------------------

 Seems very similar to House Robber I, except we have multiple paths. I think the trick is to dp from the bottom up
 as we do post order traversal

 */
public class House_Robber_III_337 {

    public static int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] money = traverse(root);
        return Math.max(money[0], money[1]);
    }

    private static int[] traverse(TreeNode root) {
        if (root == null) {
            return new int[2];
        }

        int[] left = traverse(root.left);
        int[] right = traverse(root.right);

        // now here is the trick, just like how we looked at f(-2) if we robbed this house, we need to do similar
        int[] result = new int[2];

        // not robbed...just return the max
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        //robbed, we cannot use robbed result of the children
        result[1] = root.val + left[0] + right[0];

        return result;
    }

}
