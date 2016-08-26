class Solution {
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
        int ones = ~0;
        int mask = 0;
        if (j == 31) {
            mask = (1 << i) - 1;
        } else {
            int left = ones << (j + 1);
            int right = (1 << i) - 1;
            mask = left | right;
        }

        return (n & mask) | (m << i);
    }
}
