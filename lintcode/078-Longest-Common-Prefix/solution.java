public class Solution {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String sample = strs[0];
        for (int i = 0; i < sample.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() == i) {
                    return sample.substring(0, i);
                }
                if (strs[j].charAt(i) != sample.charAt(i)) {
                    return sample.substring(0, i);
                }
            }
        }
        
        return sample;
    }
}