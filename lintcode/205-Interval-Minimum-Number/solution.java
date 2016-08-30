/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
public class Solution {

    private class SegmentTreeNode {
        int min;
        int start;
        int end;
        SegmentTreeNode left;
        SegmentTreeNode right;
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.min = Integer.MAX_VALUE;
            this.left = this.right = null;
        }
    }

    SegmentTreeNode root;

    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public ArrayList<Integer> intervalMinNumber(int[] A, 
                                                ArrayList<Interval> queries) {
        ArrayList<Integer> result = new ArrayList<>();
        root = buildTree(A, 0, A.length - 1);
        for (Interval interval : queries) {
            result.add(query(root, interval.start, interval.end));
        }

        return result;
    }

    public int query(SegmentTreeNode root, int start, int end) {
        if (start > root.end || end < root.start) {
            return -1;
        }

        if (start == root.start && end == root.end) {
            return root.min;
        }

        int mid = (root.start + root.end) / 2;

        if (start > mid) {
            return query(root.right, start, Math.min(end, root.end));
        } else if (end <= mid) {
            return query(root.left, Math.max(start, root.start), end);
        } else {
            return Math.min(
                query(root.left, start, mid),
                query(root.right, mid + 1, end)
                );
        }
    }

    public SegmentTreeNode buildTree(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }

        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start == end) {
            root.min = A[start];
            return root;
        }

        int mid = (start + end) / 2;
        root.left = buildTree(A, start, mid);
        root.right = buildTree(A, mid + 1, end);
        root.min = Math.min(root.left.min, root.right.min);

        return root;
    }
}