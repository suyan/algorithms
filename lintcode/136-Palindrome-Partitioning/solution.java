public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) {
            return result;
        }

        List<String> path = new ArrayList<>();
        findPartitions(result, path, 0, s);

        return result;
    }

    private void findPartitions(List<List<String>> result, List<String> path, int pos, String s) {
        if (pos == s.length()) {
            result.add(new ArrayList<String>(path));
            return;
        }

        for (int i = pos; i < s.length(); i++) {
            String curr = s.substring(pos, i + 1);
            if (isPalindrome(curr)) {
                path.add(curr);
                findPartitions(result, path, i + 1, s);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int begin = 0;
        int end = s.length() - 1;
        while (begin < end) {
            if (s.charAt(begin) != s.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }
}