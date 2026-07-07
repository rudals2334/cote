import java.util.Stack;

class Solution {
    boolean solution(String s) {
       Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.add('(');
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.peek() == '('){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}