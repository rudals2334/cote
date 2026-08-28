import java.util.Arrays;

class Solution {
    static int[][][] cost;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int answer;
    public int solution(int[][] board) {
        int n = board.length;
        cost = new int[n][n][4];
        answer = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }
        dfs(0, 0, -1, 0, board);
        return answer;
    }
    public void dfs(int x, int y, int dir, int total, int[][] board){
        if(x == board.length - 1 && y == board.length - 1){
            answer = Math.min(total, answer);
            return;
        }

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            int ndir = i;

            if(nx < 0 || nx >= board.length || ny < 0 || ny >= board.length){
                continue;
            }
            if(board[nx][ny] == 1) continue;

            int newTotal = 0;
            if(dir == -1 || dir == ndir){
                newTotal = total + 100;
            }else{
                newTotal = total + 600;
            }

            if(newTotal < cost[nx][ny][ndir]){
                cost[nx][ny][ndir] = newTotal;
                dfs(nx, ny, ndir, newTotal, board);
            }
        }
    }
}