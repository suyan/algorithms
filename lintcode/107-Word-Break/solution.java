public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return true;
        }

        // dp[i]: if 0 -> i can be divided
        // dp[i] = dp[k] && dict.contains(s.substring(k + 1, i + 1))
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        int maxLength = getMaxLength(dict);

        for (int i = 1; i < dp.length; i++) {
            dp[i] = false;
            for (int j = i - 1; j >= 0 && i - j <= maxLength; j--) {
                if (dp[j] == false) {
                    continue;
                }
                if (dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[dp.length - 1];
    }

    private int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        for (String s : dict) {
            maxLength = Math.max(maxLength, s.length());
        }

        return maxLength;
    }
}