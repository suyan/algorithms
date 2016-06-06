public class Solution {
    /**
     * @param A : An integer array
     * @return : An integer 
     */
    public int singleNumberII(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int[] bits = new int[32];
        for (int num : A) {
            for (int i = 0; i < 32; i++) {
                if (((num >> i) & 1) != 0) {
                    bits[i]++;
                }
            }
        }
        
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] % 3 != 0) {
                result = result | (1 << i);
            }
        }
        
        return result;
    }
}