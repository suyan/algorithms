// Basic strategy: go through all points, time limit exceeded
public class Solution {
    /**
     * @param buildings: A list of lists of integers
     * @return: Find the outline of those buildings
     */
    public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();

        int max = 0;
        for (int i = 0; i < buildings.length; i++) {
            for (int j = buildings[i][0]; j < buildings[i][1]; j++) {
                int height = buildings[i][2];
                if (!map.containsKey(j)) {
                    map.put(j, height);
                } else {
                    map.put(j, Math.max(height, map.get(j)));
                }
                max = Math.max(max, j);
            }
        }

        // go through all outlines
        for (int i = 0; i <= max; i++) {
            if (!map.containsKey(i)) {
                continue;
            }
            int start = i;
            int end = i + 1;
            int height = map.get(start);
            map.remove(start);
            while (map.containsKey(end) && map.get(end) == height) {
                map.remove(end);
                end++;
            }
            ArrayList<Integer> outline = new ArrayList<>();
            outline.add(start);
            outline.add(end);
            outline.add(height);
            result.add(outline);
            i = end - 1;
        }
        

        return result;
    }
}