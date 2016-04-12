public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        if (chars == null || chars.length < 2) {
            return;
        }
        
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] <= 'z' && chars[i] >= 'a') {
                char temp = chars[index];
                chars[index] = chars[i];
                chars[i] = temp;
                index++;
            }
        }
    }
}