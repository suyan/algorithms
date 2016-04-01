class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.size() == 0) {
            return result;
        }
        
        Collections.sort(nums);
        
        ArrayList<Integer> path = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.size()];
        getPermutation(result, path, visited, nums);
        
        return result;
    }
    
    public void getPermutation(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path, boolean[] visited, ArrayList<Integer> nums) {
        if (path.size() == nums.size()) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        
        for (int i = 0; i < nums.size(); ++i) {
            if (visited[i] == true) {
                continue;
            }
            if (i != 0 && nums.get(i) == nums.get(i - 1) && visited[i - 1] == false) {
                continue;
            }
            path.add(nums.get(i));
            visited[i] = true;
            getPermutation(result, path, visited, nums);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
