class Solution {
    /**
     * @param nums: an array of integers
     * @return: the maximum difference
     */
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        // find max number and min number
        int maxNum = nums[0];
        int minNum = nums[0];
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
            minNum = Math.min(minNum, num);
        }

        if (maxNum == minNum) {
            return 0;
        }

        int n = nums.length;

        // set bucket len, ceiling it
        int len = (int) Math.ceil((double)(maxNum - minNum) / n);

        int[] localMin = new int[n];
        int[] localMax = new int[n];

        for (int i = 0; i < n; i++) {
            localMin[i] = -1;
            localMax[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            int t = (int) ((nums[i] - minNum) / len);
            if (localMin[t] == -1) {
                localMin[t] = nums[i];
            } else {
                localMin[t] = Math.min(localMin[t], nums[i]);
            }
            localMax[t] = Math.max(localMax[t], nums[i]);
        }

        // calculate gap
        int gap = 0;
        int prev = 0;
        for (int i = 1; i < n; i++) {
            if (localMin[i] == -1) {
                continue;
            }
            gap = Math.max(gap, localMin[i] - localMax[prev]);
            prev = i;
        }

        return gap;
    }
}