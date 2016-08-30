public class Solution {
    private class SegmentTreeNode {
        long sum;
        int start;
        int end;
        SegmentTreeNode left;
        SegmentTreeNode right;
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.sum = 0;
            this.left = this.right = null;
        }
    }

    SegmentTreeNode root;

    /**
     * @param A: An integer array
     */
    public Solution(int[] A) {
        root = buildTree(A, 0, A.length - 1);
    }
    
    /**
     * @param start, end: Indices
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        return query(root, start, end);
    }
    
    /**
     * @param index, value: modify A[index] to value.
     */
    public void modify(int index, int value) {
        modify(root, index, value);
    }

    public void modify(SegmentTreeNode root, int index, int value) {
        if (index > root.end || index < root.start) {
            return;
        }

        if (root.start == index && root.end == index) {
            root.sum = value;
            return;
        }

        int mid = (root.start + root.end) / 2;
        if (root.start <= index && index <= mid) {
            modify(root.left, index, value);
        }

        if (mid < index && index <= root.end) {
            modify(root.right, index, value);
        }

        root.sum = root.left.sum + root.right.sum;
    }

    public long query(SegmentTreeNode root, int start, int end) {
        if (start > root.end || end < root.start) {
            return -1;
        }

        if (start == root.start && end == root.end) {
            return root.sum;
        }

        int mid = (root.start + root.end) / 2;

        if (start > mid) {
            return query(root.right, start, Math.min(end, root.end));
        } else if (end <= mid) {
            return query(root.left, Math.max(start, root.start), end);
        } else {
            return query(root.left, start, mid) + query(root.right, mid + 1, end);
        }
    }

    public SegmentTreeNode buildTree(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }

        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start == end) {
            root.sum = A[start];
            return root;
        }

        int mid = (start + end) / 2;
        root.left = buildTree(A, start, mid);
        root.right = buildTree(A, mid + 1, end);
        root.sum = root.left.sum + root.right.sum;

        return root;
    }
}
