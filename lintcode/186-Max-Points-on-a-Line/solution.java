/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param points an array of point
     * @return an integer
     */
    public int maxPoints(Point[] points) {
        if (points == null) {
            return 0;
        }
        int len = points.length;
        if (len <= 1) {
            return len;
        }

        int maxSize = 0;
        // from one pointer to every other points
        for (int i = 0; i < len - 1; i++) {
            Point start = points[i];
            Map<Float, Integer> slopes = new HashMap<>();
            // ignore same point
            int same = 1;

            for (int j = i + 1; j < len; j++) {
                Point end = points[j];
                if (start.x == end.x && start.y == end.y) {
                    same++;
                    continue;
                } else {
                    float slope = Float.MAX_VALUE;
                    if (start.x != end.x) {
                        slope = (float)(end.y - start.y) / (float)(end.x - start.x);
                    }
                    if (slopes.containsKey(slope)) {
                        slopes.put(slope, slopes.get(slope) + 1);
                    } else {
                        slopes.put(slope, 1);
                    }
                }
            }

            int currentMax = same;
            for (Map.Entry<Float, Integer> entry : slopes.entrySet()) {
                currentMax = Math.max(currentMax, entry.getValue() + same);
            }
            maxSize = Math.max(currentMax, maxSize);
        }

        return maxSize;
    }
}