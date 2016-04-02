// solution2 O(2 ^ n)
// fill every number to current pos

class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> result
                = new ArrayList<ArrayList<Integer>>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums); // ascending sort
        ArrayList<Integer> path = new ArrayList<Integer>();
        getSubset(result, path, nums, 0);

        return result;
    }

    private void getSubset(ArrayList<ArrayList<Integer>> result,
                           ArrayList<Integer> path,
                           int[] nums,
                           int pos
    ) {
        result.add(new ArrayList<Integer>(path));

        for (int i = pos; i < nums.length; ++i) {
            path.add(nums[i]);
            getSubset(result, path, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
