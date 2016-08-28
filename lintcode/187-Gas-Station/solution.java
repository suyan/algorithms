public class Solution {
    /**
     * @param gas: an array of integers
     * @param cost: an array of integers
     * @return: an integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currentSum = 0;
        int totalSum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            currentSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (currentSum < 0) {
                currentSum = 0;
                start = i + 1;
            }
        }

        if (totalSum >= 0) {
            // totalsum [start, gas - 1] must be positive
            return start;
        }

        return -1;
    }
}
