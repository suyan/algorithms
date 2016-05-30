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
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<Boolean> stack2 = new Stack<Boolean>();
        
        stack1.push(root);
        stack2.push(false); // if current node should be removed
        
        while (!stack1.empty()) {
            if (stack2.peek() == true) {
                result.add(stack1.pop().val);
                stack2.pop();
            } else {
                stack2.pop();
                stack2.push(true);
                TreeNode curr = stack1.peek();
                if (curr.right != null) {
                    stack1.push(curr.right);
                    stack2.push(false);
                }
                if (curr.left != null) {
                    stack1.push(curr.left);
                    stack2.push(false);
                }
            }
        }
        
        return result;
    }
}