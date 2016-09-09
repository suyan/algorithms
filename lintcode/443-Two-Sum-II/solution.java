public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        Arrays.sort(nums);

        int sum = 0;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                sum += (right - left);
                right--;
            } else {
                left++;
            }
        }

        return sum;
    }
}