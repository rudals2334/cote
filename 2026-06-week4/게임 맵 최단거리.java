import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        visited[0][0] = true;
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if(maps[ny][nx] == 0 || visited[ny][nx]) continue;

                q.add(new int[]{nx, ny});
                visited[ny][nx] = true;
                maps[ny][nx] = maps[y][x] + 1;
            }
        }

        if(maps[n-1][m-1] == 1) return -1;
        return maps[n-1][m-1];
    }
}