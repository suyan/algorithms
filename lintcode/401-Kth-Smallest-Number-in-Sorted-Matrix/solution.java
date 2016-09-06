class Number {
    public int x, y, val;
    public Number(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
class NumComparator implements Comparator<Number> {
    public int compare(Number a, Number b) {
        return a.val - b.val;
    }
}

public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    private boolean valid(int x, int y, int[][] matrix, boolean[][] hash) {
        if(x < matrix.length && y < matrix[x].length && !hash[x][y]) {
            return true;
        }
        return false;
    }
    
    int dx[] = {0,1};
    int dy[] = {1,0};
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return -1;
        }
        if (matrix.length * matrix[0].length < k) {
            return -1;
        }
        PriorityQueue<Number> heap = new PriorityQueue<Number>(k, new NumComparator());
        boolean[][] hash = new boolean[matrix.length][matrix[0].length];
        heap.add(new Number(0, 0, matrix[0][0]));
        hash[0][0] = true;
        
        for (int i = 0; i < k - 1; i ++) {
            Number smallest = heap.poll();
            for (int j = 0; j < 2; j++) {
                int nx = smallest.x + dx[j];
                int ny = smallest.y + dy[j];
                if (valid(nx, ny, matrix, hash)) {
                    hash[nx][ny] = true;
                    heap.add(new Number(nx, ny, matrix[nx][ny]));
                }
            }
        }
        return heap.peek().val;
    }
}