public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        if (values == null || values.length == 0) {
            return false;
        }
        int len = values.length;
        int sum = 0;

        // dp[i]: the max sum from i to end
        // dp[i]: max(values[i] + min(a, b) ,if just pick i
        //        values[i] + next + min(b, c)) if pick next also
        int[] dp = new int[len];

        for (int i = len - 1; i >= 0; i--) {
            sum += values[i];
            int next = i + 1 < len ? values[i + 1] : 0;
            int a = i + 2 < len ? dp[i + 2] : 0;
            int b = i + 3 < len ? dp[i + 3] : 0;
            int c = i + 4 < len ? dp[i + 4] : 0;
            dp[i] = Math.max(values[i] + Math.min(a, b),
                             values[i] + next + Math.min(b, c));
        }

        return dp[0] > sum - dp[0];
    }
}