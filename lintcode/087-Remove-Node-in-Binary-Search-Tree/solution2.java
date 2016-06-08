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
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        if (root == null) {
            return null;
        }
        
        if (root.val < value) {
            root.right = removeNode(root.right, value);
        } else if (root.val > value) {
            root.left = removeNode(root.left, value);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            
            // find min of right
            TreeNode min = root.right;
            while (min.left != null) {
                min = min.left;
            }
            
            root.val = min.val;
            root.right = removeNode(root.right, root.val);
        }
        
        return root;
    }
}