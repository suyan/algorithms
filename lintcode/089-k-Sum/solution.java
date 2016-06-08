public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int kSum(int A[], int k, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int len = A.length;
        int[][][] dp = new int[len + 1][k + 1][target + 1];
        // dp[i][j][n]: the count when pick j numbers from 0 - ith and the sum is n
        // dp[i][j][n] = dp[i - 1][j - 1][n - A[i - 1]] + dp[i - 1][j][n]
        // initialization
        for (int i = 0; i < len + 1; i++) {
            dp[i][0][0] = 1;
        }
        
        for (int i = 1; i < len + 1; i++) {
            for (int j = 1; j < k + 1 && j <= i; j++) {
                for (int n = 1; n < target + 1; n++) {
                    dp[i][j][n] = 0;
                    if (n >= A[i - 1]) { // if current number can be used
                        dp[i][j][n] = dp[i - 1][j - 1][n - A[i - 1]];
                    }
                    dp[i][j][n] += dp[i - 1][j][n]; // add if we donot use current one
                }
            }
        }
        
        return dp[len][k][target];
    }
}
