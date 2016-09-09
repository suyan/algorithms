public class Solution {
    /**
     * @param A an integer array
     * @param V an integer array
     * @param m an integer
     * @return an array
     */
    public int backPackIII(int[] A, int[] V, int m) {
        // dp[i]: the max value in i space
        int[] dp = new int[m + 1];
        for (int i = 0; i < A.length; i++) {
            for (int j = 1; j <= m; j++) {
                if (j >= A[i]) {
                    dp[j] = Math.max(dp[j], dp[j - A[i]] + V[i]);
                }
            }
        }

        return dp[m];
    }
}