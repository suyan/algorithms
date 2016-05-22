public class Solution {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if (numbers == null || numbers.length < 4) {
            return result;
        }
        
        Arrays.sort(numbers);
        
        int len = numbers.length;
        for (int i = 0; i < len - 3; i++) {
            if (i != 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                if (j != i + 1 && numbers[j] == numbers[j - 1]) {
                    continue;
                }
                int beg = j + 1;
                int end = len - 1;
                while (beg < end) {
                    if (beg != j + 1 && numbers[beg] == numbers[beg - 1]) {
                        beg++;
                        continue;
                    }
                    if (end != len - 1 && numbers[end] == numbers[end + 1]) {
                        end--;
                        continue;
                    }
                    int sum = numbers[i] + numbers[j] + numbers[beg] + numbers[end];
                    if (sum > target) {
                        end--;
                    } else if (sum < target) {
                        beg++;
                    } else {
                        ArrayList<Integer> array = new ArrayList<Integer>();
                        array.add(numbers[i]);
                        array.add(numbers[j]);
                        array.add(numbers[beg]);
                        array.add(numbers[end]);
                        result.add(array);
                        end--;
                        beg++;
                    }
                }
            }
        }
        
        return result;
    }
}