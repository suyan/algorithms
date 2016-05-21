public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        if (A == null || B == null) {
            return false;
        }

        char[] aHash = new char[256];
        char[] bHash = new char[256];
        
        for (int i = 0; i < A.length(); i++) {
            aHash[A.charAt(i)]++;
        }

        for (int i = 0; i < B.length(); i++) {
            bHash[B.charAt(i)]++;
        }
        
        for (int i = 0; i < 256; i++) {
            if (aHash[i] < bHash[i]) {
                return false;
            }
        }
        
        return true;
    }
}