public class ZigzagIterator {
    int index1;
    int index2;
    boolean outV1;
    List<Integer> v1;
    List<Integer> v2;
    /**
     * @param v1 v2 two 1d vectors
     */
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        index1 = 0;
        index2 = 0;
        this.v1 = v1;
        this.v2 = v2;
        outV1 = true;
    }

    public int next() {
        if (index1 == v1.size() && index2 == v2.size()) {
            return -1;
        }
        if (index1 == v1.size()) {
            return v2.get(index2++);
        }
        if (index2 == v2.size()) {
            return v1.get(index1++);
        }

        if (outV1) {
            outV1 = !outV1;
            return v1.get(index1++);
        } else {
            outV1 = !outV1;
            return v2.get(index2++);
        }
    }

    public boolean hasNext() {
        return !(index1 == v1.size() && index2 == v2.size());
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator solution = new ZigzagIterator(v1, v2);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */