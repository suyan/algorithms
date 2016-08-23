public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }

        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                map.put(key, new ArrayList<String>());
                map.get(key).add(str);
            }
        }

        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                result.addAll(entry.getValue());
            }
        }

        return result;
    }
}