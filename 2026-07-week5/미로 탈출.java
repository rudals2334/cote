import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static boolean visited[][];
    static int answer[][];
    
    public int solution(String[] maps) {
        String[][] arr = new String[maps.length][maps[0].length()];
        int startX = 0;
        int startY = 0;
        int leverX = 0;
        int leverY = 0;

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                arr[i][j] = String.valueOf(maps[i].charAt(j));
                if(arr[i][j].equals("S")){
                    startX = i;
                    startY = j;
                }
                if(arr[i][j].equals("L")){
                    leverX = i;
                    leverY = j;
                }
            }
        }
        int startToLever = bfs(startX, startY, arr, "L");
        if(startToLever == -1){
            return -1;
        }

        int leverToExit = bfs(leverX, leverY, arr, "E");
        if(leverToExit == -1){
            return -1;
        }

        return startToLever + leverToExit;

    }
    public int bfs(int startX, int startY, String[][] arr, String target){
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[arr.length][arr[0].length];
        answer = new int[arr.length][arr[0].length];
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        q.offer(new int[]{startX,startY});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            if(arr[x][y].equals(target)){
                return answer[x][y];
            }
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= arr.length || ny >= arr[0].length) continue;

                if(!visited[nx][ny] && !arr[nx][ny].equals("X")){
                    visited[nx][ny] = true;
                    q.offer(new int[] {nx,ny});
                    answer[nx][ny] = answer[x][y] + 1;
                }
            }
        }
        return -1;
    }
}