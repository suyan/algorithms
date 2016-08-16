class Solution {
    /**
     * @param A: An integer array.
     * @return: void
     */
    public void rerange(int[] A) {
        if (A == null) {
            return;
        }

        // check if first number is positive one or negative one
        boolean positive = false;
        int count = 0;
        for (int num : A) {
            if (num > 0) {
                count++;
            }
        }

        if (count > A.length / 2) {
            positive = true;
        }

        int pos = 0;
        int neg = 0;
        if (positive) {
            neg++;
        } else {
            pos++;
        }

        for (int i = 0; i < A.length;) {
            // in correct place
            if ((i % 2 == 0 && positive && A[i] > 0) 
                || (i % 2 == 0 && !positive && A[i] < 0)
                || (i % 2 != 0 && positive && A[i] < 0)
                || (i % 2 != 0 && !positive && A[i] > 0)) {
                i++;
            }
            // in incorrect place
            else {
                while (A[pos] > 0) {
                    pos += 2;
                }
                while (A[neg] < 0) {
                    neg += 2;
                }
                // replace positive
                if ((i % 2 == 0 && positive) || (i % 2 != 0 && !positive)) {
                    int temp = A[i];
                    A[i] = A[neg];
                    A[neg] = temp;
                } else {
                    int temp = A[i];
                    A[i] = A[pos];
                    A[pos] = temp;
                }
            }
        }
    }
}