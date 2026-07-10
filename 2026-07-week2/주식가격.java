import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < prices.length; i++){
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.add(i);
        }
        while(!stack.isEmpty()){
            int idx = stack.pop();
            answer[idx] = prices.length-1-idx;
        }
        return answer;
    }
}