public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        // corner case
        if (p.charAt(0) == '*') {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        // "" and ""
        dp[0][0] = true;
        int len1 = s.length() + 1;
        int len2 = p.length() + 1;

        // dp[i][j]: if match 0 -> i in s and 0 -> j in p
        // dp[i][j]: dp[i - 1][j - 1] && match(i, j)  if p[j] != '*'
        //           dp[i][j - 2] (don't match) || dp[i - 1][j] && match(i, j - 2) if p[j] == "*"
        // initialization: check case "x*x*x*"
        for (int j = 2; j < len2; j += 2) {
            dp[0][j] = p.charAt(j - 1) == '*' ? dp[0][j - 2] : false;
        }

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                }
            }
        }

        return dp[len1 - 1][len2 - 1];
    }
}