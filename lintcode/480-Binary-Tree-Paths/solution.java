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
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<Integer> path = new ArrayList<>();
        findPath(result, path, root);

        return result;
    }

    void findPath(List<String> result, List<Integer> path, TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i : path) {
                sb.append(i).append("->");
            }
            sb.append(root.val);
            result.add(sb.toString());
            return;
        }

        path.add(root.val);
        findPath(result, path, root.left);
        findPath(result, path, root.right);
        path.remove(path.size() - 1);
    }
}