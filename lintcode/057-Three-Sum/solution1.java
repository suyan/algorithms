// time complexity is O(n^3)
public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (numbers == null || numbers.length < 3) {
            return result;
        }
        
        Arrays.sort(numbers);
        
        int len = numbers.length;
        for (int i = 0; i < len - 2; i++) {
            if (i != 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < len - 1; j++) {
                if (j != i + 1 && numbers[j] == numbers[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < len; k++) {
                    if (k != j + 1 && numbers[k] == numbers[k - 1]) {
                        continue;
                    }
                    if (numbers[i] + numbers[j] + numbers[k] == 0) {
                        ArrayList<Integer> item = new ArrayList<Integer>();
                        item.add(numbers[i]);
                        item.add(numbers[j]);
                        item.add(numbers[k]);
                        result.add(item);
                    }
                }
            }
        }
        
        return result;
    }
}