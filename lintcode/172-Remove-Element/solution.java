public class Solution {
    /** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != elem) {
                int temp = A[i];
                A[i] = A[index];
                A[index] = temp;
                index++;
            }
        }

        return index;
    }
}
