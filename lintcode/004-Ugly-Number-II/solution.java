// solution1: brute force time O(n^2logn^2) TLE
class Solution {
    public int nthUglyNumber(int n) {
        int count = 0; 
        int i = 1;
        while (count <= n) {
            if (isUgly(i)) {
                count++;
                if (count == n) {
                    return i;
                }
            }
            i++;
        }
        return -1;
    }
    
    public boolean isUgly(int k) {
        if (k == 1) {
            return true;
        }
        while (k > 1) {
            if (k % 5 == 0 && k >= 5) {
                k = k / 5;
            } else if (k % 3 == 0 && k >= 3) {
                k = k / 3;
            } else if (k % 2 == 0 && k >= 2) {
                k = k / 2;
            } else {
                return false;
            }
        }
        return true;
    }
};

// solution 2 priority queue O(nlogn)
class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        queue.add(1L);
        set.add(1L);
        long result = 1;
        for (int i = 0; i < n; ++i) {
            result = queue.poll();
            if (!set.contains(result * 2)) {
                queue.add(result * 2);
                set.add(result * 2);
            }
            if (!set.contains(result * 3)) {
                queue.add(result * 3);
                set.add(result * 3);
            }
            if (!set.contains(result * 5)) {
                queue.add(result * 5);
                set.add(result * 5);
            }
        }
        
        return (int)result;
    }
}

// solution 3 traverse every ugly only O(n)
class Solution {
    public int nthUglyNumber(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int i2 = 0, i3 = 0, i5 = 0;

        while (list.size() < n) {
            int m2 = list.get(i2) * 2, m3 = list.get(i3) * 3, m5 = list.get(i5) * 5;
            int min = Math.min(m2, Math.min(m3, m5));
            if (min == m2) {
                i2++;
            }
            if (min == m3) {
                i3++;
            }
            if (min == m5){
                i5++;
            }
            list.add(min);
        }

        return list.get(list.size() - 1);
    }
}