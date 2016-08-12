class Solution {
public:
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    int hashCode(string key,int HASH_SIZE) {
        if (key.size() == 0) return 0;

        long long result = 0;
        long long times = 1;
        for (int i = key.size() - 1; i >= 0; i--) {
            result += (int)key[i] * times % HASH_SIZE;
            times = times * 33 % HASH_SIZE;
        }
        
        return result % HASH_SIZE;
    }
};
