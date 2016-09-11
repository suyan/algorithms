public class Solution {
    /**
     * @param nums an integer array
     * @param target an integer
     * @return the difference between the sum and the target
     */
    public int twoSumCloset(int[] nums, int target) {
        // Write your code here
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int diff = Integer.MAX_VALUE;
        while (i < j) {
            if (nums[i] + nums[j] < target) {
                if (target - nums[i] - nums[j] < diff)
                    diff = target - nums[i] - nums[j];
                i ++;
            } else {
                if (nums[i] + nums[j] - target < diff)
                    diff = nums[i] + nums[j] - target;
                j --;
            }
        }
        return diff;
    }
}