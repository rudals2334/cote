import java.util.Stack;
class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int r = 0; r < s.length(); r++){
            String rotate = s.substring(r) + s.substring(0, r);
            Stack<Character> stack = new Stack<>();
            boolean isgood = false;
            for(int i = 0; i < rotate.length(); i++){
                char bracket = rotate.charAt(i);
                if(bracket == '{' || bracket == '[' || bracket == '('){
                    stack.add(bracket);
                }else{
                    if(stack.isEmpty()){
                        isgood = false;
                        break;
                    }else{
                        if(bracket == '}'&& stack.peek().equals('{')){
                            stack.pop();
                            isgood = true;
                        }else if(bracket == ']'&& stack.peek().equals('[')){
                            stack.pop();
                            isgood = true;
                        }else if(bracket == ')'&& stack.peek().equals('(')){
                            stack.pop();
                            isgood = true;
                        }else{
                            isgood = false;
                            break;
                        }
                    }
                }
            }
            if(!stack.isEmpty()){
                isgood = false;
            }
            if(isgood){
                answer++;
            }
        }
        return answer;
    }
}