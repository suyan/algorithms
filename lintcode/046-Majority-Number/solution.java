public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return 0;
        }

        int currentNumber = nums.get(0);
        int currentCount = 0;

        for (Integer num : nums) {
            if (currentCount == 0) {
                currentCount = 1;
                currentNumber = num;
            } else if (currentNumber == num) {
                currentCount++;
            } else if (currentCount == 1) {
                currentNumber = num;
            } else {
                currentCount--;
            }
        }
        
        return currentNumber;
    }
}