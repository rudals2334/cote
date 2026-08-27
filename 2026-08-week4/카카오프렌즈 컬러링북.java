import java.util.LinkedList;
import java.util.Queue;
class Solution {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited;
    public int[] solution(int m, int n, int[][] picture){
        visited = new boolean[m][n];
        int cnt = 0;
        int max = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && picture[i][j] != 0){
                    cnt++;
                    int area = bfs(i, j, picture);
                    max = Math.max(max, area);
                }
            }
        }
        return new int[] {cnt,max};
    }
    
    public int bfs(int x, int y, int[][] picture){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});
        visited[x][y] = true;
        int count = 1;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            x = current[0];
            y = current[1];

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || nx >= picture.length || ny < 0 || ny >= picture[0].length){
                    continue;
                }

                if(!visited[nx][ny] && picture[x][y]==picture[nx][ny]){
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx,ny});
                    count++;
                }
            }
        }
        return count;
    }
}