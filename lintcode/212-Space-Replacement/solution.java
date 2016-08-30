public class Solution {
    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        char[] space = {'%', '2', '0'};
        int spaceCount = 0;
        for (int i = 0; i < length; i++) {
            if (string[i] == ' ') {
                spaceCount++;
            }
        }

        int newLength = length + (space.length - 1) * spaceCount;

        for (int i = length - 1, j = newLength - 1; i >= 0; --i) {
            if (string[i] == ' ') {
                j -= space.length;
                string[j + 1] = space[0];
                string[j + 2] = space[1];
                string[j + 3] = space[2];
            } else {
                string[j--] = string[i];
            }
        }

        return newLength;
    }
}