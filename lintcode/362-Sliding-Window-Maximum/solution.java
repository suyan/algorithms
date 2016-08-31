public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0 || k == 0 || k > nums.length) {
            return result;
        }
        // deque will store index of number
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // if q is full, pop
            if (!q.isEmpty() && q.getFirst() == i - k) {
                q.removeFirst();
            }

            // if current is larger than last, pop
            while (!q.isEmpty() && nums[i] >= nums[q.getLast()]) {
                q.removeLast();
            }
            q.addLast(i);

            if (i >= k - 1) {
                result.add(nums[q.getFirst()]);
            }
        }

        return result;
    }
}
