public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if (nums == null || nums.length == 0) {
            return result;
        }

        List<Pair> presum = new ArrayList<>(nums.length + 1);
        presum.add(new Pair(0, 0));

        for (int i = 1; i <= nums.length; i++) {
            presum.add(new Pair(presum.get(i - 1).presum + nums[i - 1], i));
        }

        Collections.sort(presum);

        int min = Math.abs(presum.get(1).presum - presum.get(0).presum);
        for (int i = 1; i < presum.size(); i++) {
            Pair first = presum.get(i);
            Pair second = presum.get(i - 1);
            int range = Math.abs(first.presum - second.presum);
            if (range <= min) {
                result[0] = Math.min(first.index, second.index);
                result[1] = Math.max(first.index, second.index) - 1;
                min = range;
            }
        }

        return result;
    }

    class Pair implements Comparable<Pair> {
        int presum;
        int index;
        public Pair(int presum, int index) {
            this.presum = presum;
            this.index = index;
        }

        @Override
        public int compareTo(Pair other) {
            return this.presum - other.presum;
        }
    }
}
