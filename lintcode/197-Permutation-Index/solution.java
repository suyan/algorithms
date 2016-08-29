public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndex(int[] A) {
        long result = 0;
        int n = A.length;

        // the number at i is the kth smallest number
        // result += (k - 1) * (n - i - 1)!

        // (n - 1)!
        long factor = 1;
        for (int i = 1; i < n; i++) {
            factor *= i;
        }

        int curr = n - 1;
        for (int i = 0; i < n; i++) {
            // get how large the number is from i -> n
            long count = 0;
            for (int j = i; j < n; j++) {
                if (A[i] >= A[j]) {
                    count++;
                }
            }

            result += (count - 1) * factor;
            if (curr != 0) {
                factor /= curr;
                curr--;
            }
        }

        // didn't add last one 
        result = result + 1;
        return result;
    }
}