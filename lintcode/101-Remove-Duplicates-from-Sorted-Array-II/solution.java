public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        
        int index = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == nums[index] && nums[i] == nums[index - 1]) {
                continue;
            }
            nums[++index] = nums[i];
        }
        
        return index + 1;
    }
}