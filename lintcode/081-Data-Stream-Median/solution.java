public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int[] result = new int[nums.length];
        MedianStream ms = new MedianStream();
        for (int i = 0; i < nums.length; i++) {
            ms.addNumber(nums[i]);
            result[i] = ms.getMedian();
        }
        
        return result;
    }
    
    private class MedianStream {
        // use two heap to keep large part and small part
        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;
        
        public MedianStream() {
            minHeap = new PriorityQueue<Integer>(10, Collections.reverseOrder());
            maxHeap = new PriorityQueue<Integer>();
        }
        
        public void addNumber(int num) {
            if (minHeap.isEmpty()) {
                minHeap.add(num);
                return;
            }

            if (num < minHeap.peek()) {
                minHeap.add(num);
                if (minHeap.size() - maxHeap.size() > 1) {
                    maxHeap.add(minHeap.poll());
                }
            } else {
                maxHeap.add(num);
                if (maxHeap.size() > minHeap.size()) {
                    minHeap.add(maxHeap.poll());
                }
            }
        }
        
        public int getMedian() {
            return minHeap.peek();
        }
    }
}