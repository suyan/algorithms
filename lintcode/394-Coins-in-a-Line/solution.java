public class Solution {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1 || n == 2) {
            return true;
        }
        return !firstWillWin(n - 1) && !firstWillWin(n - 2);
    }
}