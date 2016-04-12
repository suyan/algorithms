public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        ArrayList<Long> result = new ArrayList<Long>();
        if (A == null || A.size() == 0) {
            return result;
        }
        
        long[] left = new long[A.size()];
        left[0] = 1;
        long[] right = new long[A.size()];
        right[A.size() - 1] = 1;
        
        for (int i = 1; i < A.size(); i++) {
            left[i] = A.get(i - 1) * left[i - 1];
        }
        
        for (int i = A.size() - 2; i >= 0; i--) {
            right[i] = A.get(i + 1) * right[i + 1];
        }
        
        for (int i = 0; i < A.size(); i++) {
            result.add(left[i] * right[i]);
        }
        
        return result;
    }
}
