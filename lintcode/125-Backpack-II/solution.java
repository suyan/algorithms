public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        if (m == 0 || A == null || A.length == 0 || V == null || A.length != V.length) {
            return 0;
        }

        // dp[i][j]: use items end with i, can fill j, the max value
        // dp[i][j] = dp[i - 1][j] if j < A[i - 1]
        //            max(dp[i - 1][j], dp[i - 1][j - A[i - 1]] + V[i - 1])
        int[][] dp = new int[A.length + 1][m + 1];
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= A[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - A[i - 1]] + V[i - 1]);
                }
            }
        }

        return dp[A.length][m];
    }
}