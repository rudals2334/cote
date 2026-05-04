import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(solution(board, moves));
    }
    public static int solution(int[][] board, int[] moves){
 
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
