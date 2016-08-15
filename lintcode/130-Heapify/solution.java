public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        for (int i = A.length / 2; i >= 0; i--) {
            siftDown(A, i);
        }
    }

    private void siftDown(int[] A, int pos) {
        while (pos < A.length) {
            int left = pos * 2 + 1;
            int right = pos * 2 + 2;
            int smallest = pos;
            if (left < A.length && A[left] < A[smallest]) {
                smallest = left;
            }
            if (right < A.length && A[right] < A[smallest]) {
                smallest = right;
            }
            if (smallest == pos) {
                break;
            }
            int temp = A[smallest];
            A[smallest] = A[pos];
            A[pos] = temp;

            pos = smallest;
        }
    }
}