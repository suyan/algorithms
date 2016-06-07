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
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class BSTIterator {
    
    Stack<TreeNode> stack;
    
    //@param root: The root of binary tree.
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        return !stack.empty();
    }
    
    //@return: return next node
    public TreeNode next() {
        if (stack.empty()) {
            return null;
        }
        
        TreeNode curr = stack.pop();
        TreeNode root = curr.right;
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        
        return curr;
    }
}