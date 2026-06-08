import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static boolean[][] visited;

    public int solution(String[] board) {
        visited = new boolean[board.length][board[0].length()];
        int a = 0;
        int b = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length(); j++){
                if(board[i].charAt(j) == 'R'){
                    a = i;
                    b = j;
                }
            }
        }

        int answer = bfs(a, b, board);
        return answer;
    }

    public int bfs(int x, int y, String[] board){
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        q.offer(new int[]{x,y,0});
        visited[x][y] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cnt = cur[2];

            if(board[cx].charAt(cy)== 'G'){
                return cnt;
            }
            for(int d = 0; d < 4; d++){
                int nx = cx;
                int ny = cy;
                while(true){
                    int tx = nx + dx[d];
                    int ty = ny + dy[d];

                    if(tx < 0 || tx >= board.length ||
                        ty < 0 || ty >= board[0].length()||
                        board[tx].charAt(ty) == 'D'
                    ){
                        break;
                    }

                    nx = tx;
                    ny = ty; 
                }

                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny,cnt+1});
                }
            }
        }
        return -1;
    }
}