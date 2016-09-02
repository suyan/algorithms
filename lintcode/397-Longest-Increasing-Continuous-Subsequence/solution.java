public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        if (A == null || A.length <= 1) {
            return A.length;
        }

        int maxValue = 0;
        int increaseLength = 1; // forward
        int decreaseLength = 1; // backward
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                increaseLength++;
                decreaseLength = 1;
            } else {
                decreaseLength++;
                increaseLength = 1;
            }
            maxValue = Math.max(maxValue, increaseLength);
            maxValue = Math.max(maxValue, decreaseLength);
        }

        return maxValue;
    }
}