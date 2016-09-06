public class Solution {
    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        String aR = new StringBuilder(a).reverse().toString();
        String bR = new StringBuilder(b).reverse().toString();
        StringBuilder result = new StringBuilder();
        int carry = 0;

        int i = 0, j = 0;
        while (i < aR.length() && j < bR.length()) {
            int aInt = Character.getNumericValue(aR.charAt(i));
            int bInt = Character.getNumericValue(bR.charAt(j));
            int sum = aInt + bInt + carry;
            carry = sum / 2;
            result.append(sum % 2);
            i++;
            j++;
        }

        while (i < aR.length()) {
            int aInt = Character.getNumericValue(aR.charAt(i));
            int sum = aInt + carry;
            carry = sum / 2;
            result.append(sum % 2);
            i++;
        }

        while (j < bR.length()) {
            int bInt = Character.getNumericValue(bR.charAt(j));
            int sum = bInt + carry;
            carry = sum / 2;
            result.append(sum % 2);
            j++;
        }

        if (carry == 1) {
            result.append(1);
        }

        return result.reverse().toString();
    }
}