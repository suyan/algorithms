/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

    class Pair {
        int first;
        int second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    /**
     * @param root: The root of binary tree.
     * @return: The maximum amount of money you can rob tonight
     */
    public int houseRobber3(TreeNode root) {
        Pair max = rob(root);
        return Math.max(max.first, max.second);
    }

    public Pair rob(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }

        // if rob
        Pair left = rob(root.left);
        Pair right = rob(root.right);

        return new Pair(
            left.second + right.second + root.val,
            Math.max(left.first, left.second) + Math.max(right.first, right.second));
    }
}