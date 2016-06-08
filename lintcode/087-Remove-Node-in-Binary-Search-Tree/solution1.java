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
            return root;
        }
        
        // because root might be the value, so use a dummy node
        TreeNode dummy = new TreeNode(-1);
        dummy.left = root;
        boolean isLeft = true;
        TreeNode parent = dummy;
        TreeNode curr = root;
        // find the node of value
        while (curr != null) {
            if (curr.val < value) {
                parent = curr;
                isLeft = false;
                curr = curr.right;
            } else if (curr.val > value){
                parent = curr;
                isLeft = true;
                curr = curr.left;
            } else {
                break;
            }
        }

        if (curr == null) {
            return root;
        }
        
        // remove curr node
        if (curr.right != null) {
            TreeNode left = curr.left;
            if (isLeft) {
                parent.left = curr.right;
            } else {
                parent.right = curr.right;
            }
            curr = curr.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            curr.left = left;
        } else {
            parent.left = curr.left;
        }
        
        return dummy.left;
    }
}