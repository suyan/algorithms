public class Solution {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int beg = 0;
        int end = nums.length - 1;
        while (beg + 1 < end) {
            int mid = beg + (end - beg) / 2;
            if (target > nums[mid]) {
                beg = mid;
            } else {
                end = mid;
            }
        }
        
        if (nums[beg] == target) {
            return beg;
        }
        if (nums[end] == target) {
            return end;
        }
        if (target < nums[beg]) {
            return beg;
        } else if (target < nums[end]) {
            return end;
        } else {
            return end + 1;
        }
    }
}
