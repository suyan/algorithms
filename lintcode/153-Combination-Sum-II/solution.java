public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (num == null || num.length == 0 || target <= 0) {
            return result;
        }

        Arrays.sort(num);

        List<Integer> path = new ArrayList<>();
        findCombination(num, result, path, 0, target);

        return result;
    }

    private void findCombination(int[] num, List<List<Integer>> result, List<Integer> path, int index, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < num.length; i++) {
            if (num[i] > target) {
                break;
            }
            if (i != index && num[i] == num[i - 1]) {
                continue;
            }
            path.add(num[i]);
            findCombination(num, result, path, i + 1, target - num[i]);
            path.remove(path.size() - 1);
        }
    }
}