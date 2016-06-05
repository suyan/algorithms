/**
 * public class VersionControl {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use VersionControl.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        int beg = 1;
        int end = n;
        while (beg + 1 < end) {
            int mid = beg + (end - beg) / 2;
            if (VersionControl.isBadVersion(mid)) {
                end = mid;
            } else {
                beg = mid;
            }
        }

        if (VersionControl.isBadVersion(beg)) {
            return beg;
        }
        
        if (VersionControl.isBadVersion(end)) {
            return end;
        }
        
        return -1;
    }
}

