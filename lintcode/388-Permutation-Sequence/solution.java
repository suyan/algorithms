class Solution {
    /**
      * @param n: n
      * @param k: the kth permutation
      * @return: return the k-th permutation
      */
    public String getPermutation(int n, int k) {
        // generate factorial list
        int[] factor = new int[n + 1];
        factor[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            factor[i] = factor[i - 1] * i;
        }

        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            nums.add(i);
        }

        StringBuilder permutation = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int rank = (k - 1) / factor[n - i - 1];
            k = (k - 1) % factor[n - i - 1] + 1;
            permutation.append(nums.get(rank));
            nums.remove(rank);
        }

        return permutation.toString();
    }
}
