public class Solution {
    /**
      *@param A : an integer array
      *return : a integer 
      */
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int result = 0;
        for (int num : A) {
            result = result ^ num;
        }
        
        return result;
    }
}