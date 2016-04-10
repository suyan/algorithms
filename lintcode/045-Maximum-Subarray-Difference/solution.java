public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int size = nums.length;
        int[] leftLargestSum = new int[size];
        int[] leftSmallestSum = new int[size];
        int[] rightLargestSum = new int[size];
        int[] rightSmallestSum = new int[size];
        
        // left to right
        int largestSum = Math.max(nums[0], 0);
        int smallestSum = Math.min(nums[0], 0);
        leftLargestSum[0] = nums[0];
        leftSmallestSum[0] = nums[0];
        int presum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int currentSum = presum + nums[i];
            leftSmallestSum[i] = Math.min(leftSmallestSum[i - 1], currentSum - largestSum);
            leftLargestSum[i] = Math.max(leftLargestSum[i - 1], currentSum - smallestSum);
            largestSum = Math.max(largestSum, currentSum);
            smallestSum = Math.min(smallestSum, currentSum);
            presum = currentSum;
        }
        
        // right to left
        largestSum = Math.max(nums[size - 1], 0);
        smallestSum = Math.min(nums[size - 1], 0);
        rightLargestSum[size - 1] = nums[size - 1];
        rightSmallestSum[size - 1] = nums[size - 1];
        presum = nums[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            int currentSum = presum + nums[i];
            rightSmallestSum[i] = Math.min(rightSmallestSum[i + 1], currentSum - largestSum);
            rightLargestSum[i] = Math.max(rightLargestSum[i + 1], currentSum - smallestSum);
            largestSum = Math.max(largestSum, currentSum);
            smallestSum = Math.min(smallestSum, currentSum);
            presum = currentSum;
        }
        
        // find the largest one
        int result = 0;
        for (int i = 1; i < size; i++) {
            result = Math.max(result, leftLargestSum[i - 1] - rightSmallestSum[i]);
            result = Math.max(result, rightLargestSum[i] - leftSmallestSum[i - 1]);
        }
        
        return result;
    }
}

