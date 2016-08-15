class Solution {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        // a^n % b = (a^n/2 * a^n/2) % b
        // care about even and odd number
        if (n == 1) {
            return a % b;
        }
        if (n == 0) {
            return 1 % b;
        }

        long product = fastPower(a, b, n / 2);
        product = (product * product) % b;

        // care about odd case
        if (n % 2 == 1) {
            product = (product * a) % b;
        }

        return (int) product;
    }
}