public class Solution {
    /**
     * @param nums a list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 2; i < nums.length; i+=2) {
            int temp = nums[i];
            nums[i] = nums[i-1];
            nums[i-1] = temp;
        }
        return;
    }
}
