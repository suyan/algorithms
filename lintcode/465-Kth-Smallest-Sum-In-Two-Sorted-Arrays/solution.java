public class Solution {
    class Pair implements Comparable<Pair> {
        int x;
        int y;
        int sum;
        Pair(int x, int y, int sum) {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
        @Override
        public int compareTo(Pair another) {
            if (this.sum == another.sum) {
                return 0;
            }
            return this.sum < another.sum ? -1 : 1;
        }
        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            } else if (!(obj instanceof Pair)) {
                return false;
            }
            Pair another = (Pair) obj;
            return this.x == another.x && this.y == another.y;
        }
        @Override
        public int hashCode() {
            return x * 101 + y;
        }
    }
    /**
     * @param A an integer arrays sorted in ascending order
     * @param B an integer arrays sorted in ascending order
     * @param k an integer
     * @return an integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        if (A.length == 0 && B.length == 0) {
            return 0; 
        } else if (A.length == 0) {
            return B[k];
        } else if (B.length == 0) {
            return A[k];
        }
        int[] dx = {1, 0};
        int[] dy = {0, 1};

        HashSet<Pair> isVisited = new HashSet<Pair>();
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>();
        Pair p;
        Pair nextP;
        p = new Pair(0, 0, A[0] + B[0]);
        minHeap.offer(p);
        isVisited.add(p);
        int nextX;
        int nextY;
        int nextSum;
        for (int count = 0; count < k - 1; count++) {
            p = minHeap.poll();
            for (int i = 0; i < 2; i++) {
                nextX = p.x + dx[i];
                nextY = p.y + dy[i];
                nextP = new Pair(nextX, nextY, 0);
                if (nextX >= 0 && nextX < A.length && nextY >= 0 && nextY < B.length && !isVisited.contains(nextP)) {
                    nextSum = A[nextX] + B[nextY];
                    nextP.sum = nextSum;
                    minHeap.offer(nextP);
                    isVisited.add(nextP);
                }
            }
        }
        return minHeap.peek().sum;
    }
}