public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        int maxLength = 0;

        for (int i : num) {
            set.add(i);
        }

        while (!set.isEmpty()) {
            // get one number from set
            Iterator<Integer> it = set.iterator();
            int curr = it.next();
            set.remove(curr);
            // count consecutive numbers
            int len = set.size();
            int count = 1;
            for (int i = 1;set.contains(curr + i); i++) {
                count++;
                set.remove(curr + i);
            }
            for (int i = 1;set.contains(curr - i); i++) {
                count++;
                set.remove(curr - i);
            }
            maxLength = Math.max(maxLength, count);
        }

        return maxLength;
    }
}