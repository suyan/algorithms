public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(-1);
        result.add(-1);
        if (nums == null || nums.length == 0) {
            return result;
        }

        // the presum when end with ith number
        int[] presum = new int[nums.length + 1];
        // store presum and it's index
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 1; i <= nums.length; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
            if (map.containsKey(presum[i])) {
                result.set(0, map.get(presum[i]));
                result.set(1, i - 1);
                return result;
            }
            
            map.put(presum[i], i);
        }

        return result;
    }
}