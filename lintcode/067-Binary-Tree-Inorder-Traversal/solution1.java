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
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        
        inorder(root, result);
        
        return result;
    }
    
    public void inorder(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }
}