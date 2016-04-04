// time complexity O(n)
public class Solution {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        if (source == null || target == null || target.length() > source.length()) {
            return "";
        }
        int[] sHash = new int[256];
        int[] tHash = new int[256];
        for (int i = 0; i < target.length(); i++) {
            tHash[(int)target.charAt(i)]++;
        }
        
        int start = 0;
        int end = 0;
        String shortest = "";
        for (; end < source.length(); end++) {
            sHash[(int)source.charAt(end)]++;
            if (isValid(sHash, tHash)) {
                while (start < end && sHash[(int)source.charAt(start)] > tHash[(int)source.charAt(start)]) {
                    sHash[(int)source.charAt(start)]--;
                    start++;
                }
                if (shortest.equals("") || end - start < shortest.length()) {
                    shortest = source.substring(start, end + 1);
                }
            }
        }
        return shortest;
    }
    
    private boolean isValid(int[] sHash, int[] tHash) {
        for (int i = 0; i < sHash.length; i++) {
            if (tHash[i] > sHash[i]) {
                return false;
            }
        }
        return true;
    }
}