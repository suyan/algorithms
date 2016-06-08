public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer 
     */ 
    public ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (A == null || A.length == 0) {
            return result;
        }
        
        // sort to speed up (break when A[i] > target)
        Arrays.sort(A);
        
        ArrayList<Integer> path = new ArrayList<Integer>();
        findSum(A, result, path, k, 0, target);

        return result;
    }
    
    private void findSum(int[] A, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path, int k, int curr, int target) {
        if (path.size() == k && target == 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        
        for (int i = curr; i < A.length; i++) {
            if (A[i] <= target) {
                path.add(A[i]);
                findSum(A, result, path, k, i + 1, target - A[i]);
                path.remove(path.size() - 1);
            } else {
                break;
            }
        }
    }
}