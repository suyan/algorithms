public class Solution {
    /**
     * @param matrix an integer array of n * m matrix
     * @param k an integer
     * @return the maximum number
     */
    public int maxSlidingWindow2(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        if (m == 0 || k == 0 || n < k || m < k) {
            return 0;
        }

        int[][] presum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                presum[i][j] = matrix[i - 1][j - 1] + presum[i - 1][j] + presum[i][j - 1] - presum[i - 1][j - 1];
            }
        }

        int maxValue = Integer.MIN_VALUE;
        for (int i = k; i <= n; i++) {
            for (int j = k; j <= m; j++) {
                int value = presum[i][j] - presum[i - k][j] - presum[i][j - k] + presum[i - k][j - k];

                if (value > maxValue) {
                    maxValue = value;
                }
            }
        }

        return maxValue;
    }
}