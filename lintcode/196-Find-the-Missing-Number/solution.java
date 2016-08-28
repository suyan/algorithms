public class Solution {
    /**    
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int target = 0;
        for (int i = 0; i <= nums.length; i++) {
            target += i;
        }

        return target - sum;
    }
}