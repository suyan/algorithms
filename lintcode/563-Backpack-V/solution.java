public class Solution {
    /**
     * @param nums an integer array and all positive numbers
     * @param target an integer
     * @return an integer
     */
    public int backPackV(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            // can not choose duplicate
            for (int j = target; j >= 0; j--) {
                if (j >= nums[i]) {
                    dp[j] += dp[j-nums[i]];
                }
            }
        }
        return dp[target];
    }
}