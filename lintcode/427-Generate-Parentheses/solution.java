public class Solution {
    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }

        generate(result, "", n, n);

        return result;
    }

    // left: how many left paren we need to add 
    // right: how many right paren we need to add
    public void generate(ArrayList<String> result, String paren, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(paren);
            return;
        }

        if (left > 0) {
            generate(result, paren + "(", left - 1, right);
        }
        if (right > 0 && left < right) {
            generate(result, paren + ")", left, right - 1);
        }
    }
}