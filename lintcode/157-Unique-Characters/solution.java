public class Solution {
    /**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        boolean[] flag = new boolean[256];
        
        for (int i = 0; i < str.length(); i++) {
            if (flag[str.charAt(i)] == false) {
                flag[str.charAt(i)] = true;
            } else {
                return false;
            }
        }

        return true;
    }
}