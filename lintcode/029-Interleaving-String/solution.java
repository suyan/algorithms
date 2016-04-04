public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null
            || s3 == null
            || (s3.length() != s1.length() + s2.length())) {
            return false;
        }
        // dp[i][j]: if the string before ith in s1 and jth in s2 can form 0 - i+j in s3 
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        // initialization
        dp[0][0] = true;
        for (int i = 1; i <= s1.length(); ++i) {
            dp[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0];
        }

        for (int j = 1; j <= s2.length(); ++j) {
            dp[0][j] = s2.charAt(j - 1) == s3.charAt(j - 1) && dp[0][j - 1];
        }

        // dp[i][j] = dp[i - 1][j] if s1[i - 1] == s3[i + j - 1]
        //            dp[i][j - 1] if s2[j - 1] == s3[i + j - 1]
        for (int i = 1; i <= s1.length(); ++i) {
            for (int j = 1; j <= s2.length(); ++j) {
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j]) {
                    dp[i][j] = true;
                } else if (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1]) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}