public class Solution {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return -1;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else if (map.size() < 3) {
                map.put(num, 1);
            } else {
                // decrease every key by one
                Iterator it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry)it.next();
                    if (pair.getValue() == 1) {
                        it.remove();
                    } else {
                        pair.setValue((Integer)pair.getValue() + 1);
                    }
                }

                if (map.size() < 3) {
                    map.put(num, 1);
                }
            }
        }
        
        // set all number to 0
        for (Integer key : map.keySet()) {
            map.put(key, 0);
        }
        
        // check the really count for the numbers
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
                if (map.get(num) > nums.size() / 3)  {
                    return num;
                }
            }
        }
        
        return -1;
    }
}