public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int len = A.length;
        int[] dp = new int[len];

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= i + A[i] && j < len; j++) {
                if (dp[j] == 0 || dp[j] > dp[i] + 1) {
                    dp[j] = dp[i] + 1;
                }
            }
        }

        return dp[len - 1];
    }
}
