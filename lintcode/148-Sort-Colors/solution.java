class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        int start = 0;
        int end = nums.length - 1;
        int index = 0;
        
        while (index <= end) {
            if (nums[index] == 0) {
                swap(nums, index, start);
                start++;
                index++;
            } else if (nums[index] == 2) {
                swap(nums, index, end);
                end--;
            } else {
                index++;
            }
        }
    }
    
    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}