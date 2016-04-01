class Solution {
    public int[] mergeSortedArray(int[] A, int[] B) {
        if (A == null || A.length == 0) {
            return B;
        }
        if (B == null || B.length == 0) {
            return A;
        }
        int[] result = new int[A.length + B.length];
        int indexA = 0;
        int indexB = 0;
        while (indexA != A.length && indexB != B.length) {
            if (A[indexA] < B[indexB]) {
                result[indexA + indexB] = A[indexA++];
            } else {
                result[indexA + indexB] = B[indexB++];
            }
        }
        
        while (indexA != A.length) {
            result[indexA + indexB] = A[indexA++];
        }
        
        while (indexB != B.length) {
            result[indexA + indexB] = B[indexB++];
        }
        
        return result;
    }
}