import java.util.Stack;
class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[numbers.length];
        stack.add(0);
        for(int i = 1; i < numbers.length; i++){
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                int index = stack.pop();
                answer[index] = numbers[i];
            }
            stack.add(i);
        }
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        return answer;
    }
}