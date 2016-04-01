// 1. brute force with extra spaces
public class Solution {
    public void rotateString(char[] str, int offset) {
        if (str == null || str.length == 0) {
            return;
        }
        // be careful when offset larger than str.length
        offset = offset % str.length;

        char[] temp = new char[offset];
        
        // copy last offset elements
        for (int i = 0; i < offset; i++) {
            temp[i] = str[str.length - offset + i];
        }
        // move elements before offset position
        for (int i = str.length - offset - 1; i >= 0; --i) {
            str[i + offset] = str[i];
        }
        // copy back
        for (int i = 0; i < offset; i++) {
            str[i] = temp[i];
        }
    }
}

// 2. solution without extra spaces
// reverse three times
public class Solution {
    public void rotateString(char[] str, int offset) {
        if (str == null || str.length == 0) {
            return;
        }
        offset = offset % str.length;
        
        // reverse 0 to offset 
        reverse(str, 0, str.length - offset - 1);
        reverse(str, str.length - offset, str.length - 1);
        reverse(str, 0, str.length - 1);
    }
    public void reverse(char[] str, int begin, int end) {
        while (begin < end) {
            char temp = str[begin];
            str[begin] = str[end];
            str[end] = temp;
            begin++;
            end--;
        }
    }
}