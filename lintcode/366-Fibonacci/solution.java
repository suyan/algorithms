class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        int i_2 = 0;
        int i_1 = 1;
        while (n - 2 > 0) {
            int i = i_2 + i_1;
            i_2 = i_1;
            i_1 = i;
            n--;
        }
        
        return i_1;
    }
}

