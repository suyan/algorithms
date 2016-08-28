public class Solution {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        // find first nums[i] < nums[i + 1] from right to left
        int i = 0; 
        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            } else if (i == 0) { // already last one
                reverse(nums, 0, nums.length - 1);
                return;
            }
        }

        // find first nums[i] < nums[j] from right to left
        int j = 0;
        for (j = nums.length - 1; j > i; j--) {
            if (nums[i] < nums[j]) {
                break;
            }
        }

        // swap nums[i] and nums[j]
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

        // reverse from i + 1 to end
        reverse(nums, i + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int from, int to) {
        while (from < to) {
            int temp = nums[from];
            nums[from] = nums[to];
            nums[to] = temp;
            from++;
            to--;
        }
    }
}