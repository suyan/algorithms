public class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        
        
        int len = ratings.length;
        int[] num = new int[len];
        
        // go from left to right;
        for (int i = 0; i < len; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                num[i] = num[i - 1] + 1;
            } else {
                num[i] = 1;
            }
        }
        
        // go from right to left;
        // example [3, 2, 1]
        int sum = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (i < len - 1 && ratings[i] > ratings[i + 1]) {
                num[i] = Math.max(num[i], num[i + 1] + 1);
            }
            sum += num[i];
        }
        
        return sum;
    }
}