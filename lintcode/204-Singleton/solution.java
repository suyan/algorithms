class Solution {
    private static Solution instance = null;

    private Solution() {}

    /**
     * @return: The same instance of this class every time
     */
    public static Solution getInstance() {
        if (instance == null) {
            synchronized (Solution.class) {
                // Double check
                if (instance == null) {
                    instance = new Solution();
                }
            }
        }
        return instance;
    }
};