public class Solution {
    /**
     * @param nums an integer array and all positive numbers, no duplicates
     * @param target an integer
     * @return an integer
     */
    public int backPackIV(int[] nums, int target) {
        // dp[i]: the way to fill backpack when i size
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i] <= j) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }

        return dp[target];
    }
}