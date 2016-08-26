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
     * @param A: an integer array
     * @return: a tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {  
        return buildTree(A, 0, A.length - 1);
    }

    public TreeNode buildTree(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(A[mid]);
        root.left = buildTree(A, start, mid - 1);
        root.right = buildTree(A, mid + 1, end);

        return root;
    }
}
