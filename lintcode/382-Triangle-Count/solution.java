public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        int left = 0, right = S.length - 1;
        int sum = 0;
        Arrays.sort(S);

        for (int i = S.length - 1; i >= 2; i--) {
            left = 0;
            right = i - 1;
            while (left < right) {
                if (S[left] + S[right] > S[i]) {
                    sum += (right - left);
                    right--;
                } else {
                    left++;
                }
            }
        }

        return sum;
    }
}
