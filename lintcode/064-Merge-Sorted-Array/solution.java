class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // merge from end to start
        int pos = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[pos--] = A[i--];
            } else {
                A[pos--] = B[j--];
            }
        }
        
        while (i >= 0) {
            A[pos--] = A[i--];
        }
        while (j >= 0) {
            A[pos--] = B[j--];
        }
    }
}