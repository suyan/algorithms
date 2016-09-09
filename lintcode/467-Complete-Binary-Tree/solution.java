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
     * @param root, the root of binary tree.
     * @return true if it is a complete binary tree, or false.
     */
    public boolean isComplete(TreeNode root) {
        if (root == null) {
            return true;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        boolean isLast = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.removeFirst();
                if (curr == null) {
                    if (isLast == false) {
                        isLast = true;
                    }
                    continue;
                }
                if (isLast == true) {
                    return false;
                }

                queue.addLast(curr.left);
                queue.addLast(curr.right);
            }
        }

        return true;
    }
}