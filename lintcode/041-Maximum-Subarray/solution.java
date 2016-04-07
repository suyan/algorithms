public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // create an presum array
        int[] presum = new int[nums.length + 1];
        presum[0] = 0;
        for (int i = 0; i < nums.length; ++i) {
            presum[i + 1] = presum[i] + nums[i];
        }
        
        // so the sum from 0->1 is presum[2] - presum[0]
        // to find the largest, we should use max - min
        int largest = presum[1] - presum[0];
        int minIndex = 0;
        for (int i = 1; i < presum.length; i++) {
            if (presum[i] - presum[minIndex] > largest) {
                largest = presum[i] - presum[minIndex];
            }
            if (presum[i] < presum[minIndex]) {
                minIndex = i;
            }
        }
        
        return largest;
    }
}