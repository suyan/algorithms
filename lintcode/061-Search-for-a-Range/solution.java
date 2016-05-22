public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        int beg = 0;
        int end = nums.length - 1;
        // left bound
        while (beg + 1 < end) {
            int mid = beg + (end - beg) / 2;
            if (target > nums[mid]) {
                beg = mid;
            } else {
                end = mid;
            }
        }
        
        if (nums[beg] == target) {
            result[0] = beg;
        } else if (nums[end] == target) {
            result[0] = end;
        } else {
            return result;
        }
        
        beg = 0;
        end = nums.length - 1;
        // right bound
        while (beg + 1 < end) {
            int mid = beg + (end - beg) / 2;
            if (target < nums[mid]) {
                end = mid;
            } else {
                beg = mid;
            }
        }
        
        if (nums[end] == target) {
            result[1] = end;
        } else if (nums[beg] == target) {
            result[1] = beg;
        }
        
        return result;
    }
}
