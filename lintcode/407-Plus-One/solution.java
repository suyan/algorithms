public class Solution {
    /**
     * @param digits a number represented as an array of digits
     * @return the result
     */
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }

        reverse(digits);

        int carry = 1;
        for (int i = 0; i < digits.length; i++) {
            int sum = carry + digits[i];
            carry = sum / 10;
            digits[i] = sum % 10;
        }

        if (carry == 1) {
            int[] result = Arrays.copyOf(digits, digits.length + 1);
            result[digits.length] = 1;
            reverse(result);
            return result;
        }

        reverse(digits);

        return digits;
    }

    private void reverse(int[] digits) {
        int beg = 0;
        int end = digits.length - 1;

        while (beg < end) {
            int temp = digits[beg];
            digits[beg] = digits[end];
            digits[end] = temp;
            beg++;
            end--;
        }
    }
}