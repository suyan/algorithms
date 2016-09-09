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
     * @param a, b, the root of binary trees.
     * @return true if they are tweaked identical, or false.
     */
    public boolean isTweakedIdentical(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }

        if (isTweakedIdentical(a.left, b.left) && isTweakedIdentical(a.right, b.right)) {
            return true;
        }
        if (isTweakedIdentical(a.left, b.right) && isTweakedIdentical(a.right, b.left)) {
            return true;
        }

        return false;
    }
}