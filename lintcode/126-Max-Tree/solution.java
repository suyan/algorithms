// use a decreasing stack, O(n)
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
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        int len = A.length;

        for (int i = 0; i <= len; i++) {
            TreeNode right = new TreeNode(i == len ? Integer.MAX_VALUE : A[i]);
            while (!stack.empty() && right >= stack.peek().val) {
                TreeNode curr = stack.pop();
                if (s.empty()) {
                    right.left = curr;
                } else {
                    if (right.val < stack.peek().val) {
                        right.left = curr;
                    } else {
                        stack.peek().right = curr;
                    }
                }
            }
            stack.push(right);
        }

        return stack.peek().left;
    }
}