public class Solution {
    /**
     * @param s the string that represents a number
     * @return whether the string is a valid number
     */
    public boolean isNumber(String s) {
        int len = s.length();
        int start = 0;
        int end = len - 1;

        // remove spaces
        while (start <= end && s.charAt(start) == ' ') {
            start++;
        }
        if (start > end) {
            return false;
        }
        while (end >= start && s.charAt(end) == ' ') {
            end--;
        }

        // check sign
        if (s.charAt(start) == '+' || s.charAt(start) == '-') {
            start++;
        }

        boolean num = false;
        boolean dot = false;
        boolean exp = false;

        while (start <= end) {
            char c = s.charAt(start);
            if (Character.isDigit(c)) {
                num = true;
            } else if (c == '.') {
                if (exp || dot) {
                    return false;
                }
                dot = true;
            } else if (c == 'e') {
                if (exp || !num) {
                    return false;
                }
                exp = true;
                num = false;
            } else if (c == '+' || c == '-') {
                if (s.charAt(start - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
            start++;
        }

        return num;
    }
}