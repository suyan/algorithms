// build heap by STL heap functions
// time O(n) space O(1)
class Solution {
public:
    int kthLargestElement(int k, vector<int> nums) {
        if (nums.size() == 0) return -1;
        // build heap
        make_heap(nums.begin(), nums.end());
        
        for (int i = 0; i < k - 1; ++i) {
            pop_heap(nums.begin(), nums.end());
            nums.pop_back();
        }
        
        return nums[0];
    }
};

// partition 
// time O(nlogn) space O(1)
class Solution {
public:
    int kthLargestElement(int k, vector<int> nums) {
        int left = 0, right = nums.size() - 1;
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
        }
        if (right == k - 1) {
            return nums[right];
        }
        return -1;
    }
private:
    int partition(vector<int> &nums, int left, int right, int pivot) {
        int value = nums[pivot];
        int new_pivot = left;
        swap(nums[pivot], nums[right]);
        for (int i = left; i < right; ++i) {
            if (nums[i] > value) {
                swap(nums[i], nums[new_pivot++]);
            }
        }
        swap(nums[right], nums[new_pivot]);
        return new_pivot;
    }
};

// 