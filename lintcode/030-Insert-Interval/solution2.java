/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

// without extra space

class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        
        ListIterator<Interval> it = intervals.listIterator();

        boolean merged = true;
        while (it.hasNext()) {
            Interval curr = it.next();
            if (curr.end < newInterval.start || curr.start > newInterval.end) {
                if (merged && curr.start > newInterval.end) {
                    merged = false;
                    it.previous();
                    it.add(newInterval);
                }
            } else {
                it.remove();
                newInterval.start = Math.min(newInterval.start, curr.start);
                newInterval.end = Math.max(newInterval.end, curr.end);
            }
        }

        if (merged) {
            intervals.add(newInterval);
        }

        return intervals;
    }
}