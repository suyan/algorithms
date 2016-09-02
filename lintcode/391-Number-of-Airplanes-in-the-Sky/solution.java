/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) { 
        int maxPlanes = 0;
        int planes = 0;

        int len = airplanes.size();
        int[] starts = new int[len];
        int[] ends = new int[len];
        for (int i = 0; i < len; i++) {
            starts[i] = airplanes.get(i).start;
            ends[i] = airplanes.get(i).end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int s = 0, e = 0;
        while (s < starts.length) {
            if (starts[s] < ends[e]) {
                planes++;
                maxPlanes = Math.max(maxPlanes, planes);
                s++;
            } else {
                planes--;
                e++;
            }
        }

        return maxPlanes;
    }
}