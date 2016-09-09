public class Solution {
    /**
     * @param A an integer array
     * @param k an integer
     * @return an integer
     */
    public int postOffice(int[] A, int k) {
        int n = A.length;
        Arrays.sort(A);

        int[][] distance = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int mid = (i + j) / 2;
                for (int j = i; j <= j; k++) {
                    distance[i][j] += Math.abs(A[k - 1] - A[mid - 1]);
                }
            }
        }
    }
}