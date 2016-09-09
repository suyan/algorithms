class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: Cosine similarity.
     */
    public double cosineSimilarity(int[] A, int[] B) {
        if (A == null || A.length == 0) {
            return 2.0;
        }
        if (B == null || B.length == 0) {
            return 2.0;
        }
        if (A.length != B.length) {
            return 2.0;
        }
        if (A[0] == 0 && B[0] == 0) {
            return 2.0;
        }

        int numerator = 0;
        int average1 = 0;
        int average2 = 0;

        for (int i = 0; i < A.length; i++) {
            numerator += A[i] * B[i];
            average1 += A[i] * A[i];
            average2 += B[i] * B[i];
        }

        return numerator / (Math.sqrt(average1) * Math.sqrt(average2));
    }
}
