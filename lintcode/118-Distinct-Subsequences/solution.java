public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        if (S == null || T == null) {
            return 0;
        }

        // dp[i][j]: from 0 -> i and 0 -> j, the number of distinct subsequences
        // dp[i][j] = dp[i - 1][j] if S[i] != T[j] because we can't choose current match
        //            dp[i - 1][j] + dp[i - 1][j - 1] if S[i] == T[j] because we can choose or not

        int m = S.length();
        int n = T.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j < n + 1; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }
}