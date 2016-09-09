public class Solution {
    /**
     * @param nums a list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] result = Arrays.copyOf(nums, n);
        
        int k = (n + 1) / 2;
        int j = n;
        Arrays.sort(result);

        for (int i = 0; i < n; i++) {
            nums[i] = i % 2 == 0 ? result[--k] : result[--j];
        }
    }
}
