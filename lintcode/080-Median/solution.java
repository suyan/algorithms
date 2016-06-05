public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int k = (nums.length - 1) / 2;
        int beg = 0;
        int end = nums.length - 1;
        int mid = beg + (end - beg) / 2;
        int index = partition(nums, beg, end, mid);
        while (index != k) {
            if (index > k) {
                end = index - 1; // take care about infinite loop if not - 1
                mid = beg + (end - beg) / 2;
                index = partition(nums, beg, end, mid);
            } else {
                beg = index + 1;
                mid = beg + (end - beg) / 2;
                index = partition(nums, beg, end, mid);
            }
        }
        
        return nums[k];
    }
    
    private int partition(int[] nums, int beg, int end, int pivot) {
        // move pivot to end
        swap(nums, end, pivot);
        
        // from beg -> end, move element
        int index = beg;
        for (int i = beg; i < end; i++) {
            if (nums[i] <= nums[end]) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, end, index);
        
        return index;
    }
    
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
