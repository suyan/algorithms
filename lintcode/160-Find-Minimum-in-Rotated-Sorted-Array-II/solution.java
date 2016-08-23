public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // rotated
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // 3 cases 
            if (nums[start] == nums[mid] || nums[start] == nums[end]) {
                start++;
            } else if (nums[start] < nums[mid]) { // left is sorted
                if (nums[start] > nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else { // right is sorted
                if (nums[start] > nums[end]) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
        }

        if (nums[start] < nums[end]) {
            return nums[start];
        } else {
            return nums[end];
        }
    }
}