import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    static boolean[][] visited;
    static final int[] dx = {1,-1,0,0};
    static final int[] dy = {0,0,1,-1};

    public int solution(int[][] land) {
        visited = new boolean[land.length][land[0].length];
        int[] oil = new int[land[0].length];

        for(int i = 0; i < land.length; i++){
            for(int j = 0; j < land[i].length; j++){
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
        Set<Integer> columns = new HashSet<>();

        q.offer(new int[] {startX,startY});
        visited[startX][startY] = true;
        int size = 0;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            size++;
            columns.add(y);

            if(land[x][y] == 0) continue;

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= land.length || ny < 0 || ny >= land[0].length){
                    continue;
                }

                if(!visited[nx][ny] && land[nx][ny] == 1){
                   
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
        for(int c : columns){
            oil[c] += size;
        }
    }
}