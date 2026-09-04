class Solution {
    static int answer;
    public int solution(int n) {
        int[][] board = new int[n][n];
        answer = 0;
        dfs(0,board,n);
        return answer;
    }
    public void dfs(int row, int[][] board, int n){
        if(row == n){
            answer++;
            return;
        }

        for(int col = 0; col < n; col++){
            if(!canPlace(row,col,board,n)){
                continue;
            }
            board[row][col] = 1;
            dfs(row+1,board,n);
            board[row][col] = 0;
        }
    }
    public boolean canPlace(int row, int col, int[][] board, int n){
        for(int i = row - 1; i >= 0; i--){
            if(board[i][col] == 1) return false;
        }

        int x = row-1;
        int y = col-1;
        while (x >= 0 && y >= 0) {
            if(board[x][y] == 1){
                return false;
            }
            x--;
            y--;
        }

        x = row-1;
        y = col+1;
        while (x >= 0 && y < n) {
            if(board[x][y] == 1) {
                return false;
            }
            x--;
            y++;
        }
        return true;
    }

}