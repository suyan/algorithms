import java.util.*;
public class Main {

    public class Solution {
        public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            if (nums == null || nums.size() == 0) {
                return result;
            }
            Arrays.sort(nums); // ascending sort
            ArrayList<Integer> path = new ArrayList<Integer>();

        }

        private void getSubset(ArrayList<ArrayList<Integer>> result,
                               ArrayList<Integer> path,
                               int[] nums,
                               int pos
        ) {
            result.add(new ArrayList<Integer>(path));

            for (int i = pos; i < nums.length; ++i) {
                path.add(nums[pos]);
                getSubset(result, path, nums, pos + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
