/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return getLevel(root);
    }
    
    public int getLevel(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return getLevel(root.right) + 1;
        }
        if (root.right == null) {
            return getLevel(root.left) + 1;
        }

        int left = getLevel(root.left);
        int right = getLevel(root.right);

        return Math.min(left, right) + 1;
    }
}