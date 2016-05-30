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
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }

        int levelNumber = 0;
        while (true) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            dfs(root, 0, levelNumber, level);
            if (level.isEmpty()) {
                break;
            }
            result.add(level);
            levelNumber++;
        }

        return result;
    }

    public void dfs(TreeNode root, int currentLevel, int targetLevel, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        if (currentLevel == targetLevel) {
            result.add(root.val);
            return;
        }
        dfs(root.left, currentLevel + 1, targetLevel, result);
        dfs(root.right, currentLevel + 1, targetLevel, result);
    }
}