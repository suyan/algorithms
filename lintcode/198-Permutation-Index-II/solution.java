public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndexII(int[] A) {
        if (A == null || A.length == 0) {
            return 0L;
        }

        int len = A.length;
        Map<Integer, Integer> map = new HashMap<>();

        long index = 0, factor = 1, mulFactor = 1;
        // from right to left to count duplicate numbers
        // result += (k - 1) * (n - i)! / dumlicate!
        for (int i = len - 1; i >= 0; i--) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], 1);
            } else {
                map.put(A[i], map.get(A[i]) + 1);
                mulFactor *= map.get(A[i]);
            }

            // how larget current number is
            int count = 0;
            for (int j = i + 1; j < len; j++) {
                if (A[i] > A[j]) {
                    count++;
                }
            }

            index += count * factor / mulFactor;
            factor *= (len - i);
        }

        // don't forget first number 0
        index = index + 1;
        return index;
    }
}