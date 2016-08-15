// O(n^2) and O(1)
class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        int begin = 0;
        int end = colors.length - 1;
        for (int i = 1; i <= k / 2; i++) {
            for (int j = begin; j <= end;) {
                if (colors[j] == i) {
                    int temp = colors[begin];
                    colors[begin] = colors[j];
                    colors[j] = temp;
                    begin++;
                    j++;
                } else if (colors[j] == k - i + 1) {
                    int temp = colors[end];
                    colors[end] = colors[j];
                    colors[j] = temp;
                    end--;
                } else {
                    j++;
                }
            }
        }
    }
}