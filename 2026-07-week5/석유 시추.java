import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    static boolean[][] visited;
    static final int[] dx = {1,-1,0,0};
    static final int[] dy = {0,0,1,-1};

    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        visited = new boolean[n][m];

        int[] oil = new int[m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(land[i][j] == 1 && !visited[i][j]){
                    bfs(i, j, land, oil);
                }
            }
        }
        int answer = 0;
        for(int i = 0; i < oil.length; i++){
            answer = Math.max(answer, oil[i]);
        }
        return answer;
    }
    public void bfs(int startX, int startY, int[][] land, int[] oil){
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> colums = new HashSet<>();
        
        q.offer(new int[] {startX,startY});
        visited[startX][startY] = true;
        int size = 0;
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            size++;
            colums.add(y);

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= land.length || ny >= land[0].length) continue;

                if(!visited[nx][ny] && land[nx][ny] == 1){
                    visited[nx][ny] = true;
                    q.offer(new int[] {nx,ny});
                }
            }
        }
        for(int c : colums){
            oil[c] += size;
        }
    }
}