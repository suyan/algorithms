// O(nlogn) and O(n)
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

        ListIterator<Interval> it = intervals.listIterator();
        Interval prev = it.next();
        while (it.hasNext()) {
            Interval curr = it.next();
            if (prev.end >= curr.start) {
                prev.end = Math.max(prev.end, curr.end);
                it.remove();
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