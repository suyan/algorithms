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
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<>();
        findPath(root, path, target, result);

        return result;
    }

    private void findPath(TreeNode root, List<Integer> path, int target, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (target == root.val && root.left == null && root.right == null) {
            path.add(root.val);
            result.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        
        path.add(root.val);
        findPath(root.left, path, target - root.val, result);
        findPath(root.right, path, target - root.val, result);
        path.remove(path.size() - 1);
    }
}