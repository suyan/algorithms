public class Solution {
    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        // dp[i]: decode ways before ith
        // dp[i]: if 10 <= s[i-2, i - 1] <= 26 && s[i - 1] != 0
        //           dp[i] = dp[i - 2] + dp[i - 1] 
        //        if 10 <= s[i-2, i - 1] <= 26 && s[i - 1] == 0
        //           dp[i] = dp[i - 2]
        //        if s[i - 1] != 0
        //           dp[i] = dp[i - 1]             
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= len; i++) {
            if (!Character.isDigit(s.charAt(i - 1))) {
                return 0;
            }
            int value = Integer.valueOf(s.substring(i - 2, i));
            if (value <= 26 && value >= 10) {
                if (s.charAt(i - 1) == '0') {
                    dp[i] = dp[i - 2];
                } else {
                    dp[i] = dp[i - 2] + dp[i - 1];
                }
            } else if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }

            if (dp[i] == 0) {
                return 0;
            }
        }

        return dp[len];
    }
}