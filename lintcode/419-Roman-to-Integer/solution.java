public class Solution {
    /**
     * @param s Roman representation
     * @return an integer
     */
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int decimal = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i > 0 && map.get(c) > map.get(s.charAt(i - 1) )) {
                decimal += map.get(c) - 2 * map.get(s.charAt(i - 1));
            } else {
                decimal += map.get(c);
            }
        }

        return decimal;
    }
}