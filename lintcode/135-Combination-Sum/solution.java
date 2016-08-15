public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        
        Arrays.sort(candidates);

        List<Integer> path = new ArrayList<>();
        findTarget(result, candidates, path, target, 0);

        return result;
    }

    public void findTarget(List<List<Integer>> result, int[] candidates, List<Integer> path, int target, int pos) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = pos; i < candidates.length; i++) {
            if (candidates[i] > target) {
                continue;
            }
            // ignore duplicate number
            if (i != pos && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            // put current again
            findTarget(result, candidates, path, target - candidates[i], i);
            path.remove(path.size() - 1);
        }
    }

}