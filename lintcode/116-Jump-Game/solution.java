public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }

        int len = A.length;
        boolean[] dp = new boolean[len];
        dp[0] = true;

        for (int i = 0; i < len; i++) {
            if (dp[i] == true) {
                for (int j = i + 1; j <= i + A[i] && j < len; j++) {
                    dp[j] = true;
                }
            }
        }

        return dp[len - 1];
    }
}
