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
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }
        return buildSubTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    // divid and conquer
    // given range and create sub tree
    public TreeNode buildSubTree(int[] inorder, int iBeg, int iEnd, int[] postorder, int pBeg, int pEnd) {
        // check if this is the end
        if (iBeg > iEnd || pBeg > pEnd) {
            return null;
        }
        
        // get root node from postorder
        TreeNode root = new TreeNode(postorder[pEnd]);
        int index = indexOf(inorder, iBeg, iEnd, postorder[pEnd]);
        if (index == -1) {
            return null;
        }

        int leftCount = index - iBeg;
        int rightCount = iEnd - index;
        root.left = buildSubTree(inorder, iBeg, iBeg + leftCount - 1, postorder, pBeg, pBeg + leftCount - 1);
        root.right = buildSubTree(inorder, index + 1, iEnd, postorder, pBeg + leftCount, pEnd - 1);
        
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