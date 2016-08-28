public class Solution {
    /**
     *@param num: A list of non negative integers
     *@return: A string
     */
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = Integer.toString(nums[i]);
        }

        // sort them by combine s1 and s2
        Arrays.sort(strs, new NumbersCompartor());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }

        String result = sb.toString();
        
        // remove 0
        int index = 0;
        while (index < result.length() && result.charAt(index) == '0') {
            index++;
        }

        if (index == result.length()) {
            return "0";
        }
        return result.substring(index);
    }

    class NumbersCompartor implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return (s2 + s1).compareTo(s1 + s2);
        }
    }
}