/**
 * Definition of ArrayReader:
 * 
 * class ArrayReader {
 *      // get the number at index, return -1 if index is less than zero.
 *      public int get(int index);
 * }
 */
public class Solution {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // 1. get the index that ArrayReader.get(index) >= target in O(logk)
        // 2. Binary search the target between 0 and index
        
        int index = 1;
        while (reader.get(index - 1) < target) {
            index = index * 2;
        }

        int start = 0, end = index - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (reader.get(start) == target) {
            return start;
        }

        if (reader.get(end) == target) {
            return end;
        }

        return -1;
    }
}