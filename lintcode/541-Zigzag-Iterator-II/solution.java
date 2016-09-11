public class ZigzagIterator2 {
    int[] index;
    ArrayList<ArrayList<Integer>> vecs;
    int len;
    int it;
    /**
     * @param vecs a list of 1d vectors
     */
    public ZigzagIterator2(ArrayList<ArrayList<Integer>> vecs) {
        index = new int[vecs.size()];
        this.vecs = vecs;
        this.len = vecs.size();
        it = 0;
    }

    public int next() {
        if (!hasNext()) {
            return -1;
        }

        int result = vecs.get(it).get(index[it]);
        index[it]++;
        it = (it + 1) % len;
        return result;
    }

    public boolean hasNext() {
        if (index[it] != vecs.get(it).size()) {
            return true;
        }
        int pre = it;
        it = (it + 1) % len;
        while (it != pre && index[it] == vecs.get(it).size()) {
            it = (it + 1) % len;
        }
        if (it != pre && index[it] != vecs.get(it).size()) {
            return true;
        }
        return false;
    }
}

/**
 * Your ZigzagIterator2 object will be instantiated and called as such:
 * ZigzagIterator2 solution = new ZigzagIterator2(vecs);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */