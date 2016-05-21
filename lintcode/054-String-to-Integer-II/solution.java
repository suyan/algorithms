public class Solution {
    /**
     * @param str: A string
     * @return An integer
     */
    public int atoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        
        int beg = 0;
        // 1. ignore heading space
        while (beg < str.length() && str.charAt(beg) == ' ') {
            beg++;
        }
        
        boolean isPositive = true;
        // 2. handle sign
        if (str.charAt(beg) == '-') {
            beg++;
            isPositive = false;
        } else if (str.charAt(beg) == '+') {
            beg++;
        }
        
        // 3. get end of number
        int end = beg;
        while (end < str.length() && str.charAt(end) >= '0' && str.charAt(end) <= '9') {
            end++;
        }
        end--;
        
        long result = 0;
        long base = 1;
        // 4. from end to start, generate number
        while (end >= beg) {
            result += base * (str.charAt(end) - '0');
            if (isPositive && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (!isPositive && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            base *= 10;
            end--;
        }
        
        return isPositive ? (int)result : (int)-result;
    }
}