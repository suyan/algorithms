public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        if (nums == null || nums.size() < 2) {
            return 0;
        }
        
        // get largest from left to right
        int[] largest1 = new int[nums.size()];
        largest1[0] = nums.get(0);
        int largest = nums.get(0);
        int presum = nums.get(0);
        int smallest = Math.min(nums.get(0), 0);
        for (int i = 1; i < nums.size(); i++) {
            int currsum = presum + nums.get(i);
            largest = Math.max(largest, currsum - smallest);
            largest1[i] = largest;
            smallest = Math.min(currsum, smallest);
            presum = currsum;
        }

        // get largest from right to left
        int[] largest2 = new int[nums.size()];
        int lastElement = nums.get(nums.size() - 1);
        largest2[nums.size() - 1] = lastElement;
        largest = lastElement;
        presum = lastElement;
        smallest = Math.min(lastElement, 0);
        for (int i = nums.size() - 2; i >= 0; i--) {
            int currsum = presum + nums.get(i);
            largest = Math.max(largest, currsum - smallest);
            largest2[i] = largest;
            smallest = Math.min(currsum, smallest);
            presum = currsum;
        }
        
        largest = nums.get(0) + nums.get(nums.size() - 1);
        for (int i = 1; i < largest1.length; i++) {
            largest = Math.max(largest, largest1[i-1] + largest2[i]);
        }
        
        return largest;
    }
}

