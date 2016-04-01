class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        if (source == null || target == null || target.length() > source.length()) {
            return -1;
        }
        if (source.length() == 0 && target.length() == 0) {
            return 0;
        }
        
        for (int i = 0; i < source.length(); i++) {
            if (source.length() - i < target.length()) {
                return -1;
            }
            
            if (source.substring(i, i + target.length()).equals(target)) {
                return i;
            }
        }
        
        return -1;
    }
}