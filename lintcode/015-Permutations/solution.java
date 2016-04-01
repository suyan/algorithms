// time complexity is O(n!)
class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.size() == 0) {
            return result;
        }
        
        ArrayList<Integer> path = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.size()];
        generatePermutations(result, path, visited, nums);
        
        return result;
    }
    
    public void generatePermutations(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path, boolean[] visited, ArrayList<Integer> nums) {
        if (path.size() == nums.size()) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        
        for (int i = 0; i < nums.size(); i++) {
            if (visited[i] == true) {
                continue;
            }
            path.add(nums.get(i));
            visited[i] = true;
            generatePermutations(result, path, visited, nums);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}


// Solution2: non-recursion (next permutation algorithm in C++ STL)
class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (nums == null || nums.size() == 0) {
            return result;
        }
        
        // dont forget sort this array
        Collections.sort(nums);

        result.add(new ArrayList<Integer>(nums));
        while (nextPermutation(nums) != null) {
            result.add(new ArrayList<Integer>(nums));
        }
        return result;
    }
    
    public ArrayList<Integer> nextPermutation(ArrayList<Integer> nums) {
        // from right to left
        // 1. find nums[i] < nums[i + 1]
        // 2. find first nums[i] < nums[j]
        // 3. swap nums[i] and nums[j]
        // 4. reverse i + 1 -> end in nums
        int n = nums.size();
        int i;

        // find nums[i] < nums[i + 1]
        for (i = n - 2; i >= 0; --i) {
            if (nums.get(i) < nums.get(i + 1)) {
                break;
            }
        }
        // already last one
        if (i == -1) {
            return null;
        }
        
        // find first nums[i] < nums[j]
        int j;
        for (j = n - 1; j > i; --j) {
            if (nums.get(j) > nums.get(i)) {
                break;
            }
        }
        
        // swap nums[i] and nums[j]
        Collections.swap(nums, i, j);
        
        // reverse from i to end
        i++;
        j = n - 1;
        while (i < j) {
            Collections.swap(nums, i++, j--);
        }

        return nums;
    }
}

