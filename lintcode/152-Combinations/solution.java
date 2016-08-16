public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k == 0 || n == 0) {
            return result;
        }

        List<Integer> path = new ArrayList<>();
        findCombine(result, path, 1, n, k);
        
        return result;
    }

    private void findCombine(List<List<Integer>> result, List<Integer> path, int index, int n, int k) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (index > n) {
            return;
        }

        // do not put current number
        findCombine(result, path, index + 1, n, k);
        // put current number
        path.add(index);
        findCombine(result, path, index + 1, n, k);
        path.remove(path.size() - 1);
    }
}