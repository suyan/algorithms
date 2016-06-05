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
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder == null || preorder == null || inorder.length == 0 || preorder.length == 0 || inorder.length != preorder.length) {
            return null;
        }
        return buildSubTree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }
    
    // divid and conquer
    // given range and create sub tree
    public TreeNode buildSubTree(int[] inorder, int iBeg, int iEnd, int[] preorder, int pBeg, int pEnd) {
        // check if this is the end
        if (iBeg > iEnd || pBeg > pEnd) {
            return null;
        }
        
        // get root node from preorder
        TreeNode root = new TreeNode(preorder[pBeg]);
        int index = indexOf(inorder, iBeg, iEnd, preorder[pBeg]);
        if (index == -1) {
            return null;
        }

        int leftCount = index - iBeg;
        int rightCount = iEnd - index;
        root.left = buildSubTree(inorder, iBeg, iBeg + leftCount - 1, preorder, pBeg + 1, pBeg + leftCount);
        root.right = buildSubTree(inorder, index + 1, iEnd, preorder, pBeg + leftCount + 1, pEnd);
        
        return root;
    }
    
    public int indexOf(int[] array, int beg, int end, int value) {
        for (int i = beg; i <= end; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}