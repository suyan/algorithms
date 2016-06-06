public class Solution {
    /**
     * @param A : An integer array
     * @return : Two integers
     */
    public List<Integer> singleNumberIII(int[] A) {
        List<Integer> result = new ArrayList<Integer>();
        if (A == null || A.length == 0) {
            return result;
        }
        
        int x1xorx2 = 0;
        for (int num : A) {
            x1xorx2 = x1xorx2 ^ num;
        }
        
        // get last one's position of x1xorx2
        int lastOne = x1xorx2 - (x1xorx2 & (x1xorx2 - 1));
        int one = 0, two = 0;
        for (int num : A) {
            if ((num & lastOne) != 0) {
                one = one ^ num;
            } else {
                two = two ^ num;
            }
        }
        
        result.add(one);
        result.add(two);
        
        return result;
    }
}