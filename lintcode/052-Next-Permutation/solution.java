public class Solution {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public int[] nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        
        // 1. from right to left, find first nums[i] < nums[i + 1]
        int size = nums.length;
        int i = size - 2;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        
        if (i < 0) {
            reverseArray(nums, 0, size - 1);
            return nums;
        }
        
        // 2. from right to left, find first nums[j] > nums[i]
        int j = size - 1;
        for (; j >= 0; j--) {
            if (nums[j] > nums[i]) {
                break;
            }
        }
        
        // 3. swap nums[i] and nums[j]
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        
        // 4. reverse i + 1 -> end
        reverseArray(nums, i + 1, size - 1);
        
        return nums;
    }
    
    private void reverseArray(int[] nums, int beg, int end) {
        while (beg < end) {
            int temp = nums[beg];
            nums[beg] = nums[end];
            nums[end] = temp;
            beg++;
            end--;
        }
    }
}