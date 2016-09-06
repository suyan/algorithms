public class Solution {
    /**
     * @param n the nth
     * @return the nth sequence
     */
    public String countAndSay(int n) {
        if (n == 0) {
            return "";
        }

        String curr = "1";
        for (int i = 1; i < n; i++) {
            int index = 0;
            StringBuilder next = new StringBuilder();
            while (index < curr.length()) {
                int same = 1;
                while (index + 1 < curr.length() && curr.charAt(index + 1) == curr.charAt(index)) {
                    ++same;
                    ++index;
                }

                next.append(same);
                next.append(curr.charAt(index));
                index++;
            }
            curr = next.toString();
        }

        return curr;
    }
}