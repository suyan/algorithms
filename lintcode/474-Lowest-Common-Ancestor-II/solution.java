/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */
public class Solution {
    /**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        if (A == null || B == null || root == null) {
            return null;
        }

        int hA = getHeight(A);
        int hB = getHeight(B);

        if (hA < hB) {
            for (int i = 0; i < hB - hA; i++) {
                B = B.parent;
            }
        } else {
            for (int i = 0; i < hA - hB; i++) {
                A = A.parent;
            }
        }

        while (A != B) {
            A = A.parent;
            B = B.parent;
        }

        return A;
    }

    int getHeight(ParentTreeNode root) {
        int height = 0;
        while (root.parent != null) {
            ++height;
            root = root.parent;
        }

        return height;
    }
}
