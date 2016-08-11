public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }

        // dp[i][j]: minimum distance from 0->i in word1 and 0->j in word2
        // dp[i][j] = min(dp[i-1][j-1], dp[i-1][j] + 1, dp[i][j-1] + 1) if word1[i] == word2[j]
        //            min(dp[i-1][j-1] + 1, dp[i-1][j] + 1, dp[i][j-1] + 1) if not equal
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
  
        for (int i = 1; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j < n + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int minDistance = Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1);
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    minDistance = Math.min(minDistance, dp[i - 1][j - 1]);
                } else {
                    minDistance = Math.min(minDistance, dp[i - 1][j - 1] + 1);
                }
                dp[i][j] = minDistance;
            }
        }

        return dp[m][n];
    }
}