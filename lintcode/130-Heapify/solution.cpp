class Solution {
public:
    void heapify(vector<int> &A) {
        for (int i = A.size() / 2; i >= 0; i--) {
            siftDown(A, i);
        }
    }
private:
    void siftDown(vector<int> &A, int k) {
        while (k < A.size()) {
            int smallest = k;
            if (k * 2 + 1 < A.size() && A[k * 2 + 1] < A[smallest]) {
                smallest = k * 2 + 1;
            }
            if (k * 2 + 2 < A.size() && A[k * 2 + 2] < A[smallest]) {
                smallest = k * 2 + 2;
            }
            if (smallest == k) {
                break;
            }
            int temp = A[smallest];
            A[smallest] = A[k];
            A[k] = temp;
            
            k = smallest;
        }
    }
};
