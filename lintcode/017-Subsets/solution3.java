// solution3 bit manipulation
// O(2 ^ n)
// iterate every number between 0 - 2^n, mapping every number in nums to the number

class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> result = 
            new ArrayList<ArrayList<Integer>>();
            
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        long end = (long)Math.pow(2, nums.length);
        
        for (int i = 0; i < end; ++i) {
            ArrayList<Integer> path = new ArrayList<Integer>();
            // test ith bit
            // bool = (1 << i) & num
            for (int j = 0; j < nums.length; ++j) {
                if (((1 << j) & i) != 0) {
                    path.add(nums[j]);
                }
            }
            
            result.add(new ArrayList<Integer>(path));
        }
        
        return result;
    }
}