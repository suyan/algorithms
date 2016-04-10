public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        
        int largest = Math.max(nums.get(0), 0);
        int presum = nums.get(0);
        int smallest = nums.get(0);
        
        for (int i = 1; i < nums.size(); i++) {
            int currsum = presum + nums.get(i);
            smallest = Math.min(smallest, currsum - largest);
            largest = Math.max(currsum, largest);
            presum = currsum;
        }
        
        return smallest;
    }
}
