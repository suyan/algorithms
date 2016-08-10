public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return 0;
        }
        
        int len = triangle.length;
        
        int[] dp = new int[len];
        for (int i = 0; i < triangle[len - 1].length; i++) {
            dp[i] = triangle[len - 1][i];
        }

        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (dp[j] < dp[j + 1]) {
                    dp[j] = triangle[i][j] + dp[j];
                } else {
                    dp[j] = triangle[i][j] + dp[j + 1];
                }
            }
        }

        return dp[0];
    }
}
