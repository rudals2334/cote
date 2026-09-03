class Solution {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        return dfs(aloc, bloc, board);
    }
    public int dfs(int[] cur, int[] other, int[][] board){
        int x = cur[0];
        int y = cur[1];

        if(board[x][y] == 0){
            return 0;
        }
        int win = Integer.MAX_VALUE;
        int lose = 0;
        boolean canMove = false;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) continue;

            if(board[nx][ny] == 0) continue;
            board[x][y] = 0;
            canMove = true;
            int result = dfs(other, new int[] {nx,ny}, board);
            int total = result + 1;

            board[x][y] = 1;
            
            if(total % 2 == 1){
                win = Math.min(total, win);
            }else{
                lose = Math.max(total, lose);
            }
        }

        if(!canMove){
            return 0;
        }

        if(win != Integer.MAX_VALUE){
            return win;
        }
        return lose;
    }
}