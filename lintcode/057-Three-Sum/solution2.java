// time complexity O(n^2)
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if (numbers == null || numbers.length < 3) {
            return result;
        }
        
        Arrays.sort(numbers);
        
        int len = numbers.length;
        for (int i = 0; i < len; i++) {
            if (i != 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int beg = i + 1;
            int end = len - 1;
            while (beg < end) {
                if (beg != i + 1 && numbers[beg] == numbers[beg - 1]) {
                    beg++;
                    continue;
                }
                if (end != len - 1 && numbers[end] == numbers[end + 1]) {
                    end--;
                    continue;
                }
                int sum = numbers[i] + numbers[beg] + numbers[end];
                if (sum > 0) {
                    end--;
                } else if (sum < 0) {
                    beg++;
                } else {
                    ArrayList<Integer> array = new ArrayList<Integer>();
                    array.add(numbers[i]);
                    array.add(numbers[beg]);
                    array.add(numbers[end]);
                    result.add(array);
                    end--;
                    beg++;
                }
            }
        }
        
        return result;
    }
}