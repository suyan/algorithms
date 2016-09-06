public class Solution {
    /**
     * @param x the base number
     * @param n the power number
     * @return the result
     */
    public double myPow(double x, int n) {
        int exp = Math.abs(n);
        double base = x;
        double result = 1;
        while (exp != 0) {
            if ((exp & 1) != 0) {
                result *= base;
            }
            base *= base;
            exp >>= 1;
        }

        if (n < 0) {
            result = 1 / result;
        }

        return result;
    }
}