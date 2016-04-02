// solution1 O(2^n) recursion
// for every number, there are two status: choose or not 
class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);

        ArrayList<Integer> path = new ArrayList<Integer>();
        getSubset(result, path, nums, 0);
        
        return result;
    }
    
    private void getSubset(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path, int[] nums, int pos) {
        if (pos == nums.length) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        // choose or not
        path.add(nums[pos]);
        getSubset(result, path, nums, pos + 1);
        path.remove(path.size() - 1);
        getSubset(result, path, nums, pos + 1);
    }
}