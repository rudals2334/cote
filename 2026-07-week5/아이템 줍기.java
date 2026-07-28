import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[][] map = new int[102][102];
    static boolean[][] visited = new boolean[102][102];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for(int[] r : rectangle){
            r[0] *= 2;
            r[1] *= 2;
            r[2] *= 2;
            r[3] *= 2;
        }

        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;

        for(int[] r : rectangle){
            int x1 = r[0];
            int y1 = r[1];
            int x2 = r[2];
            int y2 = r[3];
            for(int i = x1; i <= x2; i++){
                for(int j = y1; j <= y2; j++){
                    map[i][j] = 1;
                }
            }
        }
        for(int[] r : rectangle){
            int x1 = r[0];
            int y1 = r[1];
            int x2 = r[2];
            int y2 = r[3];
            for(int i = x1+1; i < x2; i++){
                for(int j = y1+1; j < y2; j++){
                    map[i][j] = 0;
                }
            }
        }
        int answer = bfs(characterX, characterY, itemX, itemY);
        return answer;
    }
    public static int bfs(int characterX, int characterY, int itemX, int itemY){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {characterX, characterY,0});
        visited[characterX][characterY] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            if(x == itemX && y == itemY) return dist / 2;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= 102 || ny >= 102) continue;
                if(!visited[nx][ny] && map[nx][ny] == 1){
                    visited[nx][ny] = true;
                    q.offer(new int[] {nx,ny,dist+1});
                }
            }
        }
        return -1;
    }
}