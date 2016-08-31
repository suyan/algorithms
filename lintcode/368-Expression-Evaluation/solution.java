public class Solution {
    /**
     * @param expression: an array of strings;
     * @return: an integer
     */
    public int evaluateExpression(String[] expression) {
        Stack<Integer> intStack = new Stack<Integer>();
        Stack<String> opStack = new Stack<String>();

        int index = 0;
        while (index < expression.length) {
            String curr = expression[index];
            if (isOp(curr)) {
                if (curr.equals("(")) { // just push
                    opStack.push(curr);
                } else if (curr.equals(")")) { // pop until (
                    while (!opStack.peek().equals("(")) {
                        intStack.push(calculate(intStack.pop(), intStack.pop(), opStack.pop()));
                    }
                    opStack.pop();
                } else {
                    // lower priority will 
                    while (!opStack.isEmpty() && precedence(curr, opStack.peek())) {
                        intStack.push(calculate(intStack.pop(), intStack.pop(), opStack.pop()));
                    }
                    opStack.push(curr);
                }
            } else {
                intStack.push(Integer.valueOf(curr));
            }
            index++;
        }

        while (!opStack.isEmpty()) {
            intStack.push(calculate(intStack.pop(), intStack.pop(), opStack.pop()));
        }

        return intStack.isEmpty() ? 0 : intStack.pop();
    }

    int calculate(int a, int b, String op) {
        if (op.equals("+")) {
            return b + a;
        } else if (op.equals("-")) {
            return b - a;
        } else if (op.equals("*")) {
            return b * a;
        } else {
            return b / a;
        }
    }

    boolean isOp(String str) {
        String ops = "+-*/()";
        if (ops.indexOf(str) != -1) {
            return true;
        } else {
            return false;
        }
    }

    boolean precedence(String a, String b) {
        if (b.equals("*") || b.equals("/")) {  
            return true;  
        }  
        if (b.equals("+") || b.equals("-")) {  
            if(a.equals("*") || a.equals("/")) {  
                return false;  
            } else {  
                return true;  
            }  
        }  
        return false;
    }
}