import java.util.Stack;
class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        for(int i = 0; i < moves.length; i++){
            int a = moves[i];
            for(int j = 0; j <board.length; j++){
                if(board[j][a-1]!=0){
                    if(stack.isEmpty()){
                        stack.add(board[j][a-1]);
                        board[j][a-1] = 0;
                        break;
                    }else{
                        if(stack.peek() == board[j][a-1]){
                            stack.pop();
                            cnt += 2;
                            board[j][a-1] = 0;
                            break;
                        }else{
                            stack.add(board[j][a-1]);
                            board[j][a-1] = 0;
                            break;
                        }
                    }
                }
            }
        }  
        return cnt;
    }
}