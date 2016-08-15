// use a heap, time limit exceeded
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

        List<Interval> list = new ArrayList<Interval>();
        PriorityQueue<Interval> queue = new PriorityQueue<Interval>();
        for (int i = 0; i < buildings.length; i++) {
            queue.add(new Interval(buildings[i][0], buildings[i][1], buildings[i][2]));
        }

        while (!queue.isEmpty()) {
            Interval curr = queue.remove();
            if (queue.isEmpty()) {
                list.add(curr);
                break;
            }
            Interval next = queue.peek();
            if (curr.end == next.start && curr.height == next.height) {
                queue.remove();
                queue.add(new Interval(curr.start, next.end, curr.height));
                continue;
            } 
            if (curr.end <= next.start) {
                list.add(curr);
                continue;
            }
            for (Interval i : mergeIntervals(curr, queue.remove())) {
                queue.add(i);
            }
        }

        for (Interval i : list) {
            if (i.start == i.end) continue;
            ArrayList<Integer> item = new ArrayList<>();
            item.add(i.start);
            item.add(i.end);
            item.add(i.height);
            result.add(item);
        }

        return result;
    }

    private List<Interval> mergeIntervals(Interval i1, Interval i2) {
        List<Interval> list = new ArrayList<Interval>();
        if (i1.start > i2.start) {
            return mergeIntervals(i2, i1);
        }
        if (i1.end == i2.start && i1.height == i2.height) {
            list.add(new Interval(i1.start, i2.end, i1.height));
            return list;
        }

        if (i1.end < i2.start) {
            list.add(i1);
            list.add(i2);
            return list;
        }

        if (i1.height > i2.height) {
            if (i2.end <= i1.end) {
                list.add(i1);
            } else {
                list.add(i1);
                list.add(new Interval(i1.end, i2.end, i2.height));
            }
        } else {
            if (i2.end < i1.end) {
                list.add(i2);
                list.add(new Interval(i1.start, i2.start, i1.height));
                list.add(new Interval(i2.end, i1.end, i1.height));
            } else {
                list.add(i2);
                list.add(new Interval(i1.start, i2.start, i1.height));
            }
        }
        return list;
    }

    class Interval implements Comparable<Interval> {
        int start;
        int end;
        int height;
        public Interval(int start, int end, int height) {
            this.start = start;
            this.end = end;
            this.height = height;
        }

        @Override
        public int compareTo(Interval other) {
            if (this.start < other.start) {
                return -1;
            } else if (this.start == other.start) {
                return other.height - this.height;
            } else {
                return 1;
            }
        }
    }
}