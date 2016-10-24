package leetcode.questions.data_structures.binary_search_tree;

import leetcode.models.TreeNode;

/**

 Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

 ---------------------------------------------------------------------------------------------------

 Take the median, and just call left and right

 */
public class Convert_Sorted_Array_Binary_Search_Tree_108 {

    public static TreeNode sortedArrayToBST(int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return null;
        }

        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private static TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start == end) {
            return new TreeNode(nums[start]);
        }

        int median = start + ((end - start + 1) >> 1);

        TreeNode root = new TreeNode(nums[median]);

        if (start < median) {
            root.left = sortedArrayToBST(nums, start, median - 1);
        }
        if (median < end) {
            root.right = sortedArrayToBST(nums, median + 1, end);
        }

        return root;
    }

}
