class Solution {
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
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
        return -1;
    }
}