class Solution {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        long base = 5;
        long count = 0;
        while (n / base != 0) {
            count += n / base;
            base *= 5;
        }
        return count;
    }
};
