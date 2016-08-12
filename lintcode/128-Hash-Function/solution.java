class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        if (key == null || key.length == 0) {
            return 0;
        }
        int number = 33;
        long curr = 1;
        long result = 0;
        for (int i = key.length - 1; i >= 0; i--) {
            result += curr * key[i] % HASH_SIZE;
            curr = (number * curr) % HASH_SIZE;
        }

        return (int) (result % HASH_SIZE);
    }
};