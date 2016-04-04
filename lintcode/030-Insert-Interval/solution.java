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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();

        boolean merged = true;
        for (Interval curr : intervals) {
            if (curr.end < newInterval.start || curr.start > newInterval.end) {
                if (merged && curr.start > newInterval.end) {
                    result.add(newInterval);
                    merged = false;
                }
                result.add(curr);
            } else {
                newInterval.start = Math.min(curr.start, newInterval.start);
                newInterval.end = Math.max(curr.end, newInterval.end);
                merged = true;
            }
        }

        if (merged) {
            result.add(newInterval);
        }

        return result;
    }
}