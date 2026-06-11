import java.util.Stack;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char bracket = s.charAt(i);
            if(bracket == '('){
                stack.add(bracket);
            }else{
                if(!stack.isEmpty()){
                    if(stack.peek()=='('){
                        stack.pop();
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }

        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}