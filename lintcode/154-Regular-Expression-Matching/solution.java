public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        // base case
        if (p.length() == 0) {
            return s.length() == 0;
        }
        // special case
        if (p.length() == 1) {
            // if the length of s is 0
            if (s.length() == 0) {
                return false;
            }
            // if the first doesn't match
            else if (p.charAt(0) != s.charAt(0) && p.charAt(0) != '.') {
                return false;
            } else {
                return isMatch(s.substring(1), p.substring(1));
            }
        }
        // case 1: the second char of p is not "*"
        if (p.charAt(1) != '*') {
            if (s.length() == 0) {
                return false;
            }
            if (p.charAt(0) != s.charAt(0) && p.charAt(0) != '.') {
                return false;
            } else {
                return isMatch(s.substring(1), p.substring(1));
            }
        }
        // case 2: the second char of p is "*"
        else {
            // match no chars
            if (isMatch(s, p.substring(2))) {
                return true;
            }
            // match 1 or more element
            int i = 0;
            while (i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
                if (isMatch(s.substring(i + 1), p.substring(2))) {
                    return true;
                }
                i++;
            }
            return false;
        }
    }
}