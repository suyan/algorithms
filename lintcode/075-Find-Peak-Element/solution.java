class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int beg = 0;
        int end = A.length - 1;
        while (beg + 1 < end) {
            int mid = beg + (end - beg) / 2;
            if (A[mid + 1] > A[mid]) {
                beg = mid;
            } else {
                end = mid;
            }
        }
        
        if (A[beg] > A[end]) {
            return beg;
        } else {
            return end;
        }
    }
}
