public class Solution {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int i = 0;
        int j = s.length() - 1;
        int len = s.length();
        while (i < j) {
            while (!Character.isLetter(s.charAt(i)) && i < len - 1) {
                i++;
            }
            while (!Character.isLetter(s.charAt(j)) && j > 0) {
                j--;
            }
            if (i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}