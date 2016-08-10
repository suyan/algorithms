public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        // dp[i]: the minimum number of cuts end with ith
        // dp[i] = dp[k] + 1 if isPalindrome(s.substring(k, i))
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if (isPalindrome(s.substring(j, i))) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }

        // minus 1 because I assume cut at the end
        return dp[dp.length - 1] - 1;
    }

    private boolean isPalindrome(String s) {
        int begin = 0;
        int end = s.length() - 1;
        while (begin < end) {
            if (s.charAt(begin) != s.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }

        return true;
    }
}