public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        int[] sCount = new int[256];
        int[] tCount = new int[256];

        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            tCount[t.charAt(i)]++;
        }

        for (int i = 0; i < sCount.length; i++) {
            if (sCount[i] != tCount[i]) {
                return false;
            }
        }

        return true;
    }
};