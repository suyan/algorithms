public class Solution {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0;
        int j = 0;
        int minDiff = Integer.MAX_VALUE;

        while (i < A.length && j < B.length) {
            if (A[i] > B[j]) {
                minDiff = Math.min(minDiff, A[i] - B[j]);
                j++;
            } else {
                minDiff = Math.min(minDiff, B[j] - A[i]);
                i++;
            }
        }

        return minDiff;
    }
}
