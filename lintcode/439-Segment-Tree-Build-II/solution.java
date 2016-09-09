/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param A: a list of integer
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int[] A) {
        return build(A, 0, A.length - 1);
    }

    SegmentTreeNode build(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }

        SegmentTreeNode root = new SegmentTreeNode(start, end, Integer.MAX_VALUE);
        if (start == end) {
            root.max = A[start];
            return root;
        }

        root.left = build(A, start, (start + end) / 2);
        root.right = build(A, (start + end) / 2 + 1, end);

        int left_max = root.left != null ? root.left.max : Integer.MAX_VALUE;
        int right_max = root.right != null ? root.right.max : Integer.MAX_VALUE;

        root.max = Math.max(left_max, right_max);

        return root;
    }
}