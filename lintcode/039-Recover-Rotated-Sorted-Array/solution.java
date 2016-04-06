public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return;
        }
        
        // find the rotated pos
        int index = 0;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) > nums.get(i)) {
                index = i;
            }
        }
        
        // reverse first part
        reverseArray(nums, 0, index - 1);
        // reverse second part
        reverseArray(nums, index, nums.size() - 1);
        //reverse whole array
        reverseArray(nums, 0, nums.size() - 1);
    }
    
    private void reverseArray(ArrayList<Integer> nums, int start, int end) {
        while (start < end) {
            int temp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);
            start++;
            end--;
        }
    }
}