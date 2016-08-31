public class Solution {  
    /** 
     * @param expression: A string array 
     * @return: The Reverse Polish notation of this expression 
     */  
    public ArrayList<String> convertToRPN(String[] expression) {  
        ArrayList<String> list = new ArrayList<String>();  
        Stack<String> stack = new Stack<String>();  
          
        for (int i = 0; i < expression.length; i++) {  
            String str = expression[i];  
            if (isOp(str)) {  
                if (str.equals("(")) {  
                    stack.push(str);  
                } else if (str.equals(")")) {  
                    while (!stack.isEmpty()) {  
                        String p = stack.pop();  
                        if (p.equals("(")) {  
                            break;  
                        }  
                        list.add(p);  
                    }  
                } else {  
                    while (!stack.isEmpty() && order(str) <= order(stack.peek())) {  
                        list.add(stack.pop());  
                    }  
                    stack.push(str);  
                }  
            } else {  
                list.add(str);  
            }  
        }  
        while (!stack.isEmpty()) {  
            list.add(stack.pop());  
        }  
        return list;  
    }  
      
    boolean isOp(String str) {  
        if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")  
            || str.equals("(") || str.equals(")")) {  
            return true;  
        } else {  
            return false;  
        }  
    }  
  
    int order(String a) {  
        if (a.equals("*") || a.equals("/")) {  
            return 2;  
        } else if (a.equals("+") || a.equals("-")) {  
            return 1;  
        } else {  
            return 0;  
        }  
    }  
      
}  