class Solution {
    public int digitCounts(int k, int n) {
        int count = 0;
        int factor = 1;
        int low = 0, cur = 0, high = 0;
        
        if (k == 0 && n == 0) {
            return 1;
        }
        
        while (n / factor > 0) {
            low = n - (n / factor) * factor;
            cur = (n / factor) % 10;
            high = n / (factor * 10);
            
            if (n / factor / 10 == 0 && k == 0) {
            } else if (cur < k) {
                count += high * factor;
            } else if (cur == k) {
                count += high * factor + low + 1;
            } else {
                count += (high + 1) * factor;
            }
            
            factor *= 10;
        }
        
        return count;
    }
};
