public class Solution {
    /**
     * @param A an integer array
     * @return an integer
     */
    public int stoneGame(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int len = A.length;
        // dp[i][j]: the min value from i->j
        // ret[i][j]: the sum from i -> j
        int[][] dp = new int[len][len];
        int[][] ret = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 0;
            ret[i][i] = A[i];
        }

        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                ret[i][j] = ret[i][j - 1] + A[j];
                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    min = Math.min(min, dp[i][k] + dp[k + 1][j] + ret[i][j]);
                }
                dp[i][j] = min;
            }
        }

        return dp[0][len - 1];
    }
}