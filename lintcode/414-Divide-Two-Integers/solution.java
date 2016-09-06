public class Solution {
    /**
     * @param dividend the dividend
     * @param divisor the divisor
     * @return the result
     */
    public int divide(int dividend, int divisor) {
        long result = 0;
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);

        // find the max one 
        long count = 1; // minus times
        int i = 0; // the power of 2
        while (dvd >= dvs) {
            dvs = dvs << 1;
            count = count << 1;
            ++i;
        }

        while (dvs != 0 && i >= 0) {
            if (dvd >= dvs) {
                dvd -= dvs;
                result += count;
            }
            dvs = dvs >> 1;
            count = count >> 1;
            --i;
        }

        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            return (int) -result;
        } else {
            if (result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return (int) result;
            }
        }
    }
}