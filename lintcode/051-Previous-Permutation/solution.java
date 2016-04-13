public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
        if (nums == null || nums.size() < 2) {
            return nums;
        }
        
        int size = nums.size();
        // 1. find nums[i] > nums[j]
        int index = size - 2;
        for (; index >= 0; index--) {
            if (nums.get(index) > nums.get(index + 1)) {
                break;
            }
        }
        if (index < 0) {
            Collections.reverse(nums);
            return nums;
        }
        
        // 2. find nums[j] < nums[index]
        int j = size - 1;
        for (; j >= 0; j--) {
            if (nums.get(j) < nums.get(index)) {
                break;
            }
        }
        
        // 3. swap nums[index] nums[j]
        Collections.swap(nums, index, j);
        
        // 4. reverse index + 1 -> end
        reverseArray(nums, index + 1, size - 1);
        
        return nums;
    }
    
    private void reverseArray(ArrayList<Integer> nums, int beg, int end) {
        while (beg < end) {
            int temp = nums.get(beg);
            nums.set(beg, nums.get(end));
            nums.set(end, temp);
            beg++;
            end--;
        }
    }
}
