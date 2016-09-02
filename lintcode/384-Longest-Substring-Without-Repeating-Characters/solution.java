public class Solution {
    /**
     * @param s: a string
     * @return: an integer 
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        Set<Character> set = new HashSet<>();

        int left = 0, maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                while (left < i && s.charAt(left) != c) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            } else {
                set.add(c);
                maxLength = Math.max(maxLength, i - left + 1);
            }
        }

        return maxLength;
    }
}