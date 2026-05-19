import java.util.*;
class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(stack.isEmpty()){
                stack.add(s.charAt(i));
            }else{
                if(stack.peek().equals(s.charAt(i))){
                    stack.pop();
                    continue;
                }else{
                    stack.add(s.charAt(i));
                }
            }
        }
        if(stack.isEmpty()){
            return 1;
        }else return 0;
    }
}