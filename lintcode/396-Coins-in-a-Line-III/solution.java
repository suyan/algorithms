public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        int len = values.length;
        if (len <= 1) {
            return true;
        }

        // dp[i][j]: max value you can get from i -> j
        // dp[i][j] = max(A[i] + sum[i + 1][j] - dp[i + 1][j],
        //                A[j] + sum[i][j - 1] - dp[i][j - 1]);
        // because A[i] + sum[i + 1][j] == A[j] + sum[i][j - 1] == sum[i][j]
        // dp[i][j] = sum[i][j] - min(dp[i + 1][j], dp[i][j - 1])
        int[][] store = new int[len][len];
        int[][] sum = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                sum[i][j] = i == j ? values[j] : sum[i][j - 1] + values[j];
            }
        }

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    store[i][j] = values[i];
                } else {
                    int curr = Math.min(store[i + 1][j], store[i][j - 1]);
                    store[i][j] = sum[i][j] - curr;
                }
            }
        }

        return store[0][len - 1] > sum[0][len - 1] - store[0][len - 1];
    }
}