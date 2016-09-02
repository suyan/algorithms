public class Solution {
    /**
     * @param s : A string
     * @return : The length of the longest substring 
     *           that contains at most k distinct characters.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0 || s == null || s.length() == 0) {
            return 0;
        }
        int maxLength = 0;
        int left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            char curr = s.charAt(right);
            if (map.containsKey(curr)) { // already exist
                map.put(curr, map.get(curr) + 1);
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else if (map.size() < k) { // smaller than k
                map.put(curr, 1);
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else { // equal to k but will exceed
                // shrink to make size smaller than k
                while (map.size() == k) {
                    char leftChar = s.charAt(left);
                    if (map.get(leftChar) == 1) {
                        map.remove(leftChar);
                    } else {
                        map.put(leftChar, map.get(leftChar) - 1);
                    }
                    left++;
                }
            }
        }

        return maxLength;
    }
}