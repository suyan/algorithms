class Solution {
    public int aplusb(int a, int b) {
        int result = a ^ b;
        int carry = a & b;
        if (carry != 0) {
            carry = carry << 1;
            return aplusb(result, carry);
        }
        return result;
    }
};