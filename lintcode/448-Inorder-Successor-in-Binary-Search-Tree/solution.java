/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while (root != null && root.val != p.val) {
            if (root.val > p.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        // didn't find
        if (root == null) {
            return null;
        }

        // no right, get its parent
        if (root.right == null) {
            return successor;
        }

        // find left one from right subtree
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }
}