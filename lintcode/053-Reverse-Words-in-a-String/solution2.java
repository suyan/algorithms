public class Solution {
    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int index = s.length() - 1;
        while (index >= 0 && s.charAt(index) == ' ') {
            index--;
        }

        boolean isWord = true;
        while (index >= 0) {
            if (s.charAt(index) != ' ') {
                sb.append(s.charAt(index));
                isWord = true;
            } else if (isWord) {
                sb.append(" ");
                isWord = false;
            }
            index--;
        }

        // reverse every word
        int start = 0;
        int end = 0;
        while (end < sb.length()) {
            if (end == sb.length() - 1) {
                reverse(sb, start, end);
            } else if (sb.charAt(end) == ' ') {
                reverse(sb, start, end - 1);
                start = end + 1;
            }
            end++;
        }

        return sb.toString();
    }

    private void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}