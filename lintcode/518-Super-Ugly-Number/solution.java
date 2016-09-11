public class Solution {
    /**
     * @param n a positive integer
     * @param primes the given prime list
     * @return the nth super ugly number
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 0 || n == 1) {
            return n;
        }
        PriorityQueue<Long> queue = new PriorityQueue<>();
        Set<Long> visited = new HashSet<>();
        queue.add(1L);
        visited.add(1L);

        for (int i = 1; i < n; i++) {
            // remove one from queue
            long curr = queue.remove();
            for (int prime : primes) {
                if (visited.contains(curr * prime)) {
                    continue;
                }
                visited.add(curr * prime);
                queue.add(curr * prime);
            }
        }

        return queue.remove().intValue();
    }
}