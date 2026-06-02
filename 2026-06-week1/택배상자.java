import java.util.Stack;
class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        int k = 1;
        for(int i = 0; i < order.length; i++){
            while(true){
                if(order[i] < k){
                    if(stack.peek()==order[i] && !stack.isEmpty()){
                        stack.pop();
                        answer++;
                        break;
                    }else{
                        return answer;
                    }
                }else if(order[i] > k){
                    stack.add(k);
                    k++;
                }else{
                    answer++;
                    k++;
                    break;
                }
            }
        }
        return answer;
    }
}