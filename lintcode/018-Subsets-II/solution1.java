class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> result = 
            new ArrayList<ArrayList<Integer>>();

        if (S == null || S.size() == 0) {
            return result;
        }
        
        Collections.sort(S);
        ArrayList<Integer> path = new ArrayList<Integer>();
        getSubset(result, path, S, 0);
        
        return result;
    }
    
    private void getSubset(ArrayList<ArrayList<Integer>> result,
        ArrayList<Integer> path,
        ArrayList<Integer> S,
        int pos
    ) {
        result.add(new ArrayList<Integer>(path));
        
        for (int i = pos; i < S.size(); ++i) {
            if (i != pos && S.get(i) == S.get(i - 1)) {
                continue;
            }

            path.add(S.get(i));
            getSubset(result, path, S, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
