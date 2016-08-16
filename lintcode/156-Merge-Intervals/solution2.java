/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals, a collection of intervals
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return intervals;
        }

        Collections.sort(intervals, new MyComparator());

        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            // if overlap
            Interval curr = intervals.get(i);
            if (prev.end >= curr.start) {
                prev.end = Math.max(prev.end, curr.end);
                intervals.remove(i);
            } else {
                prev = curr;
            }
        }

        return intervals;
    }

    class MyComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval i1, Interval i2) {
            if (i1.start < i2.start) {
                return -1;
            } else if (i1.start == i2.start) {
                return i1.end - i2.end;
            } else {
                return 1;
            }
        }
    }
}