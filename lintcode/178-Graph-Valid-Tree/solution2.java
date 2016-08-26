// O(V + E)
public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            if (uf.find(a) == uf.find(b)) {
                // a and b already connected
                return false;
            } else {
                uf.union(a, b);
            }
        }

        return uf.count() == 1;
    }

    class UnionFind {
        private int[] father;
        private int count;

        public UnionFind(int n) {
            father = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }

        public int count() {
            return count;
        }

        public void union(int a, int b) {
            int fa = find(a);
            int fb = find(b);
            if (fa != fb) {
                father[fa] = fb;
                count--;
            }
        }

        // compressed find
        public int find(int x) {
            // find root of x
            int root = father[x];
            while (root != father[root]) {
                root = father[root];
            }

            // compress
            int curr = x;
            while (curr != root) {
                int temp = father[curr];
                father[curr] = root;
                curr = temp;
            }

            return root;
        }
    }
}