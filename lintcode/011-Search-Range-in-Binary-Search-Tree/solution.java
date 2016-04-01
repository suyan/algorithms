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
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // divide and conquer
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        if (root.val >= k1 && root.val <= k2) { // both left and right
            result.addAll(searchRange(root.left, k1, root.val));
            result.add(root.val);
            result.addAll(searchRange(root.right, root.val, k2));
        } else if (root.val < k1) { // go right
            result.addAll(searchRange(root.right, k1, k2));
        } else if (root.val > k2) { // go left
            result.addAll(searchRange(root.left, k1, k2));
        }
        
        return result;
    }
}