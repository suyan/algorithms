// solution1 brute force, sort and find k O
// time O(nlogn) space O(n)
class Solution {
    public int kthLargestElement(int k, int[] nums) {
        if (nums == null || nums.length < k || k == 0) {
            return -1;
        }
        ArrayList<Integer> array = new ArrayList<>();
        for (int i : nums) {
            array.add(i);
        }
        Collections.sort(array, Collections.reverseOrder());
        return array.get(k - 1);
    }
};

// solution2 quick sort way
// time O(nlogn) space O(1)
class Solution {
    public int kthLargestElement(int k, int[] nums) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int pivot = partition(nums, left, right, mid);
            if (pivot > k - 1) {
                right = pivot;
            } else {
                left = pivot;
            }
        }
        
        if (left == k - 1) {
            return nums[left];
        } else if (right == k - 1) {
            return nums[right];
        }
        
        return -1;
    }
    
    // return the position of pivot
    public int partition(int[] nums, int left, int right, int pivot) {
        swap(nums, pivot, right);
        int newIndex = left;
        for (int i = left; i < right; i++) {
            if (nums[i] > nums[right]) {
                swap(nums, i, newIndex);
                newIndex++;
            }
        }
        swap(nums, newIndex, right);
        
        return newIndex;
    }
    
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

// solution 3 make a heap 
// time O(n) space O(1)
class Solution {
    public int kthLargestElement(int k, int[] nums) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            return -1;
        }
        // build heap
        for (int i = nums.length / 2 - 1; i >= 0; --i) {
            siftDown(nums, i, nums.length - 1);
        }

        // remove k elements
        for (int i = 1; i < k; ++i) {
            int temp = nums[0];
            nums[0] = nums[nums.length - i];
            nums[nums.length - i] = temp;
            siftDown(nums, 0, nums.length - i - 1);
        }
        
        return nums[0];
    }
    
    public void siftDown(int[] nums, int beg, int end) {
        int curr = beg;
        int child = curr * 2 + 1;
        while (child <= end) {
            if (child + 1 <= end && nums[child] < nums[child + 1]) {
                child++;
            }
            if (nums[curr] < nums[child]) {
                int temp = nums[curr];
                nums[curr] = nums[child];
                nums[child] = temp;
                curr = child;
                child = curr * 2 + 1;
            } else {
                break;
            }
        }
    }
}

// Solution4 priority queue O(nlogk)
class Solution {
    public int kthLargestElement(int k, int[] nums) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            return -1;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : nums) {
            if (queue.size() < k) {
                queue.add(i);
            } else if (i > queue.peek()) {
                queue.poll();
                queue.add(i);
            }
        }
        
        return queue.peek();
    }
}