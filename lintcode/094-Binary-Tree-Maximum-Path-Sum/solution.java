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
    private int maxValue = Integer.MIN_VALUE;
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxPathSum(TreeNode root) {
        getMaxValue(root);
        
        return maxValue;
    }
    
    // return the max path sum the root node can provide to
    // also update maxValue with the path go through root
    private int getMaxValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftMaxValue = getMaxValue(root.left);
        int rightMaxValue = getMaxValue(root.right);
        
        int localMax = root.val;
        if (leftMaxValue > 0) {
            localMax += leftMaxValue;
        }
        if (rightMaxValue > 0) {
            localMax += rightMaxValue;
        }
        maxValue = Math.max(maxValue, localMax);
        
        int branchMax = Math.max(leftMaxValue, rightMaxValue);
        if (branchMax > 0) {
            return branchMax + root.val;
        } else {
            return root.val;
        }
    }
}