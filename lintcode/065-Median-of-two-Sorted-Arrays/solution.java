class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        if (A == null || B == null) {
            return -1;
        }
        int len = A.length + B.length;
        if (len % 2 == 0) {
            int a = findKthElement(A, B, 0, A.length - 1, 0, B.length - 1, len / 2);
            int b = findKthElement(A, B, 0, A.length - 1, 0, B.length - 1, len / 2 + 1);
            return (double) (a + b) / 2;
        } else {
            return findKthElement(A, B, 0, A.length - 1, 0, B.length - 1, len / 2 + 1);
        }
    }
    
    public int findKthElement(int[] A, int[] B, int aBeg, int aEnd, int bBeg, int bEnd, int k) {
        if (k == 1) {
            if (aEnd - aBeg < 0) {
                return B[bBeg];
            } else if (bEnd - bBeg < 0) {
                return A[aBeg];
            } else {
                return A[aBeg] < B[bBeg] ? A[aBeg] : B[bBeg];                
            }
        }
        
        // don't remove short one
        if (aEnd - aBeg + 1 < k / 2) {
            return findKthElement(A, B, aBeg, aEnd, bBeg + k / 2, bEnd, k - k / 2);
        }
        if (bEnd - bBeg + 1 < k / 2) {
            return findKthElement(A, B, aBeg + k / 2, aEnd, bBeg, bEnd, k - k / 2);
        }
        
        if (A[aBeg + k / 2 - 1] < B[bBeg + k / 2 - 1]) {
            return findKthElement(A, B, aBeg + k / 2, aEnd, bBeg, bEnd, k - k / 2);
        } else {
            return findKthElement(A, B, aBeg, aEnd, bBeg + k / 2, bEnd, k - k / 2);
        }
    }
}
