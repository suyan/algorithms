// Recursion, time limit exceeded
public class Solution {
    /**
     * @paramn n: An integer
     * @return: An integer
     */
    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int left = i == 1 ? 1 : i - 1;
            int right = i == n ? 1 : n - i;
            sum += numTrees(left) * numTrees(right);
        }

        return sum;
    }
}