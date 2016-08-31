public class Solution {
    /**
     * @param num: an integer
     * @return: an integer, the number of ones in num
     */
    public int countOnes(int num) {
        if (num == 0) {
            return 0;
        }

        int sum = 0;
        while (num != 0) {
            num = num & (num - 1);
            sum++;
        }

        return sum;
    }
}