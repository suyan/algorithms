public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return 0;
        }
        // ABCD
        // EACD
        // dp[i][j]: the LCS before ith in A and jth in B
        // dp[i][j] = max(dp[i - 1][j - 1] + 1, dp[i - 1][j], dp[i][j - 1]) if A[i] == B[j]
        //            max(dp[i - 1][j], dp[i][j - 1]) if A[i] != B[j]
        
        // initialize
        int[][] dp = new int[A.length() + 1][B.length() + 1];
        for (int i = 0; i <= A.length(); i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= B.length(); j++) {
            dp[0][j] = 0;
        }
        
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1] + 1);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[A.length()][B.length()];
    }
}
