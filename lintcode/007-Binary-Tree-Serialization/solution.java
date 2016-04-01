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
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder("");
        if (root == null) {
            return sb.toString();
        }
        // do dfs to build tree, use "#" to represent null
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
            TreeNode curr = stack.pop();
            if (curr == null) {
                sb.append("#,");
            } else {
                sb.append(curr.val).append(",");
                stack.add(curr.right);
                stack.add(curr.left);
            }
        }
        // remove last comma
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        
        StringTokenizer st = new StringTokenizer(data, ",");
        return readTree(st);
    }
    
    public TreeNode readTree(StringTokenizer st) {
        if (!st.hasMoreTokens()) {
            return null;
        }
        
        String val = st.nextToken();
        if (val.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = readTree(st);
        root.right = readTree(st);
        
        return root;
    }
}
