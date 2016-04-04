// time complexity O(n)
public class Solution {
    /** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        int index = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < k) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
        }
        return index;
    }
}