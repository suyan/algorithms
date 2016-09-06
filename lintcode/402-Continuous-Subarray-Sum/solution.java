public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(0);

        int len = A.length;
        if (len < 2) {
            return result;
        }

        int[] presum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            presum[i] = presum[i - 1] + A[i - 1];
        }

        int minIndex = 0;
        int max = A[0];
        for (int i = 1; i <= len; i++) {
            if (presum[i] - presum[minIndex] > max) {
                max = presum[i] - presum[minIndex];
                result.set(0, minIndex);
                result.set(1, i - 1);
            }
            if (presum[i] < presum[minIndex]) {
                minIndex = i;
            }
        }

        return result;
    }
}