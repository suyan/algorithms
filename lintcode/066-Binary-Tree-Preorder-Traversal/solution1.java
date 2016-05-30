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
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        
        preorder(root, result);
        
        return result;
    }
    
    public void preorder(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }
}