// without float
class Solution {
public:
    /**
     * @param points an array of point
     * @return an integer
     */
    int maxPoints(vector<Point>& points) {
        int len = (int)points.size();
        if (len <= 1) {
            return len;
        }

        int maxSize = 0;
        // from one pointer to every other points
        for (int i = 0; i < len - 1; ++i) {
            const auto &start = points[i];
            unordered_map<string, int> slopes;
            int same = 1;

            for (int j = i + 1; j < len; ++j) {
                const auto &end = points[j];
                if (start.x == end.x && start.y == end.y) {
                    ++same;
                    continue;
                } else {
                    string slope = "infinite";
                    int y = end.y - start.y;
                    int x = end.x - start.x;
                    int gcd = getGCD(x, y);
                    if (start.x != end.x) {
                        slope = to_string(y/gcd).append("/").append(to_string(x/gcd));
                    }
                    ++slopes[slope];
                }
            }

            int currentMax = same;
            for (const auto &count : slopes) {
                currentMax = max(currentMax, count.second + same);
            }
            maxSize = max(currentMax, maxSize);
        }

        return maxSize;
    }

    int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }
};