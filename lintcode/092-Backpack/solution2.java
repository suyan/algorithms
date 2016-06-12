public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        // dp[i][k]: the max value we can fill with capacity k from element before i
        // dp[i][k] = max(dp[i - 1][k], dp[i - 1][k - A[i]])
        int[][] dp = new int[A.length][m + 1];
        // initialize first line
        for (int i = 0; i < m + 1; i++) {
            if (i >= A[0]) {
                dp[0][i] = A[0];
            }
        }
        
        for (int i = 1; i < A.length; i++) {
            for (int k = 0; k < m + 1; k++) {
                if (k >= A[i]) {
                    dp[i][k] = Math.max(dp[i - 1][k], dp[i - 1][k - A[i]] + A[i]);
                } else { // we cant put i in this capacity
                    dp[i][k] = dp[i - 1][k];
                }
            }
        }
        
        return dp[A.length - 1][m];
    }
}