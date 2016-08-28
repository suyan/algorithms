public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        // dp[i][j]: 0->i from s, 0->j from t can match
        // dp[i][j]: [i] == [j] && dp[i - 1][j - 1]
        //           [j] == ? && dp[i - 1][j - 1]
        //           [j] == * && (dp[i - 1][j - 1] || dp[i][j - 1])
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int j = 1; j < p.length() + 1; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                char schar = s.charAt(i - 1);
                char pchar = p.charAt(j - 1);
                if (pchar == '*') {
                    dp[i][j] = dp[i - 1][j - 1] || dp[i][j - 1] || dp[i - 1][j];
                } else if (schar == pchar || pchar == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}