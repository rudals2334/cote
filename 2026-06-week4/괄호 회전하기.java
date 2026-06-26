import java.util.Stack;
class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < s.length(); i++){
            String a = s.substring(i) + s.substring(0,i);
            Stack<Character> stack = new Stack<>();
            boolean rotate = true;
            for(int j = 0; j < a.length(); j++){
                char bracket = a.charAt(j);
                if(bracket == '[' || bracket == '(' || bracket == '{'){
                    stack.add(bracket);
                }else{
                    if(stack.isEmpty()){
                        rotate = false;
                        break;
                    }else{
                        if(bracket == '}' && stack.peek() == '{'){
                            stack.pop();
                        }else if(bracket == ')' && stack.peek() == '('){
                            stack.pop();
                        }else if(bracket == ']' && stack.peek() == '['){
                            stack.pop();
                        }else{
                            rotate = false;
                            break;
                        }
                    }
                }
            }

            if(rotate && stack.isEmpty()){
                answer++;
            }   
        }
        return answer;
    }
}