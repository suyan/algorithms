class Solution {
    /*
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        // return false when n <= 0
        if (n <= 0) {
            return false;
        }
        // remove last 1 get 0
        return (n & (n - 1)) == 0;
    }
};