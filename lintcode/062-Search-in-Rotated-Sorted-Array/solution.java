public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int beg = 0;
        int end = nums.length - 1;
        while (beg + 1 < end) {
            int mid = beg + (end - beg) / 2;
            // check which part is ordered
            if (nums[mid] < nums[end]) { // right side is ordered
                if (target <= nums[end] && target >= nums[mid]) { // in ordered side
                    beg = mid;
                } else {
                    end = mid;
                }
            } else { // left side is ordered
                if (target <= nums[mid] && target >= nums[beg]) {
                    end = mid;
                } else {
                    beg = mid;
                }
            }
        }
        
        if (nums[beg] == target) {
            return beg;
        } else if (nums[end] == target) {
            return end;
        } else {
            return -1;
        }
    }
}
