public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
        if (numbers == null || numbers.length < 3) {
            return -1;
        }
        Arrays.sort(numbers);
        int len = numbers.length;
        int mostCloset = Integer.MAX_VALUE;
        int theSum = 0;
        
        for (int i = 0; i < len; i++) {
            int beg = i + 1;
            int end = len - 1;
            while (beg < end) {
                int sum = numbers[i] + numbers[beg] + numbers[end];
                int closet = Math.abs(sum - target);
                if (closet < mostCloset) {
                    mostCloset = closet;
                    theSum = sum;
                }
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    beg++;
                } else {
                    beg++;
                    end--;
                }
            }
        }
        
        return theSum;
    }
}