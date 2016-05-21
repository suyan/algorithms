public class Solution {
    public class Pair implements Comparable<Pair> {
        public int value;
        public int index;
        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
        
        public int compareTo(Pair other) {
            return this.value - other.value;
        }
    }
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if (numbers == null || numbers.length == 0) {
            return result;
        }
        // sort the array, and use two pointers to find the target
        // [2, 7, 11, 15] beg 0   end 3
        Pair[] pairs = new Pair[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            pairs[i] = new Pair(numbers[i], i);
        }

        Arrays.sort(pairs);
        
        int beg = 0;
        int end = pairs.length - 1;
        while (beg < end) {
            if (pairs[beg].value + pairs[end].value > target) {
                end--;
            } else if (pairs[beg].value + pairs[end].value < target) {
                beg++;
            } else {
                if (pairs[beg].index < pairs[end].index) {
                    result[0] = pairs[beg].index + 1;
                    result[1] = pairs[end].index + 1;
                } else {
                    result[0] = pairs[end].index + 1;
                    result[1] = pairs[beg].index + 1;
                }
                return result;
            }
        }
        
        return result;
    }
}