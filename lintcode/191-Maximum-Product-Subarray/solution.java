public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // max product end with ith
        int[] maxPro = new int[nums.length];
        // min product end with ith
        int[] minPro = new int[nums.length];
        maxPro[0] = nums[0];
        minPro[0] = nums[0];

        int maxValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                maxPro[i] = Math.max(minPro[i - 1] * nums[i], nums[i]);
                minPro[i] = Math.min(maxPro[i - 1] * nums[i], nums[i]);
            } else if (nums[i] > 0) {
                minPro[i] = Math.min(minPro[i - 1] * nums[i], nums[i]);
                maxPro[i] = Math.max(maxPro[i - 1] * nums[i], nums[i]);
            } else {
                maxPro[i] = 0;
                minPro[i] = 0;
            }
            maxValue = Math.max(maxValue, maxPro[i]);
        }

        return maxValue;
    }
}