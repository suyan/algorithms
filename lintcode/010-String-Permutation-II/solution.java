public class Solution {
    public List<String> stringPermutation2(String str) {
        if (str == null) {
            return new ArrayList<String>();
        }

        // to avoid duplicate, should sort it first
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        
        Set<String> set = new HashSet<>();
        boolean[] visited = new boolean[str.length()];
        StringBuilder path = new StringBuilder();
        getPermutation(set, visited, path, chars);
        
        return new ArrayList<String>(set);
    }
    
    // fill permutations in result 
    public void getPermutation(Set<String> set, boolean[] visited, StringBuilder path, char[] chars) {
        if (path.length() == chars.length) {
            set.add(path.toString());
        }
        
        for (int i = 0; i < chars.length; i++) {
            if (visited[i] == true) {
                continue;
            }
            path.append(chars[i]);
            visited[i] = true;
            getPermutation(set, visited, path, chars);
            path.deleteCharAt(path.length() - 1);
            visited[i] = false;
            // will be TLE if not do as follows
            // don't choose same char next time 
            while (i + 1 < chars.length && chars[i + 1] == chars[i]) {
                i++;
            }
        }
    }
}