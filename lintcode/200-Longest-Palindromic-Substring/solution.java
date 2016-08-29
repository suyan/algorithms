/**
 * Brute force is n^2
 */
public class Solution {
    /**
     * @param s input string
     * @return the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String result = s.substring(0, 1);

        for (int i = 0; i < s.length() - 1; i++) {
            String curr = "";
            // odd number string
            int from = i;
            int end = i;
            while (from >= 0 && end <= s.length() - 1) {
                if (s.charAt(from) != s.charAt(end)) {
                    break;
                }
                from--;
                end++;
            }
            curr = s.substring(from + 1, end);
            if (curr.length() > result.length()) {
                result = curr;
            }
            // even number string
            from = i;
            end = i + 1;
            while (from >= 0 && end <= s.length() - 1) {
                if (s.charAt(from) != s.charAt(end)) {
                    break;
                }
                from--;
                end++;
            }
            curr = s.substring(from + 1, end);
            if (curr.length() > result.length()) {
                result = curr;
            }
        }

        return result;
    }
}