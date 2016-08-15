class Solution {
    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
        ArrayList<String> result = new ArrayList<>();
        if (dictionary == null || dictionary.length == 0) {
            return result;
        }

        int maxLength = 0;
        for (String s : dictionary) {
            if (s.length() == maxLength) {
                result.add(s);
            } else if (s.length() < maxLength) {
                continue;
            } else {
                maxLength = s.length();
                result.clear();
                result.add(s);
            }
        }

        return result;
    }
}