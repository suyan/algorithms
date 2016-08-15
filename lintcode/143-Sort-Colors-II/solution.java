// O(n) and O(n)
class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        int[] count = new int[k];
        for (int i : colors) {
            count[i - 1]++;
        }

        int index = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < count[i]; j++) {
                colors[index++] = i + 1;
            }
        }
    }
}