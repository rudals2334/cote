import java.util.Stack;
class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        int idx = 1;
        for(int i = 0; i < order.length; i++){
            while(true){
                if(order[i] < idx){
                    if(stack.peek()==order[i] && !stack.isEmpty()){
                        stack.pop();
                        answer++;
                        break;
                    }else{
                        return answer;
                    }
                }else if(order[i] > idx){
                    stack.add(idx);
                    idx++;
                }else{
                    answer++;
                    idx++;
                    break;
                }
            }
        }
        return answer;
    }
}