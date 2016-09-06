public class Solution {
    /**
     * @param A an integer array
     * @param start an integer
     * @param end an integer
     * @return the number of possible answer
     */
    public int subarraySumII(int[] A, int start, int end) {
        int len = A.length;
        int[] presum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            presum[i] = presum[i - 1] + A[i - 1];
        }

        int temp, result = 0;
        for (int i = 0; i < presum.length - 1; i ++) {
            for (int j = i + 1; j < presum.length; j++) {
                temp = presum[j] - presum[i];
                if (temp >= start && temp <= end) {
                    result++;
                }
            }
        }

        return result;
    }
}