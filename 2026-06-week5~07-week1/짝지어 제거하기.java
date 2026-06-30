import java.util.Stack;
class Solution{
    public int solution(String s){
        Stack<Character> stack = new Stack<>();
        stack.add(s.charAt(0));
        for(int i = 1; i < s.length(); i++){
            char a = s.charAt(i);
            if(!stack.isEmpty() && a == stack.peek()){
                stack.pop();
            }else{
                stack.add(a);
            }
        }
        if(stack.isEmpty()){
            return 1;
        }else{
            return 0;
        }
    }
}