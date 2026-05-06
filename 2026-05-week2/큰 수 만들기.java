import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        
        for(int i = 0; i < number.length(); i++){
            int a = number.charAt(i) - '0';
            while(cnt < k && !stack.isEmpty() && a > stack.peek()){
                stack.pop();
                cnt++;
            }
            stack.push(a);
        }
        while(cnt < k){
            stack.pop();
            cnt++;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}