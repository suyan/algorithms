class Solution {
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int aBit = a & 1;
            int bBit = b & 1;
            if (aBit != bBit) {
                count++;
            }
            a = a >> 1;
            b = b >> 1;
        }

        return count;
    }
}
