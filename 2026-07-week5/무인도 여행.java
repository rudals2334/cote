import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    static boolean visited[][];
    static int cnt;
    public int[] solution(String[] maps) {
        String[][] arr = new String[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[i].length(); j++){
                arr[i][j] = String.valueOf(maps[i].charAt(j));
            }
        }
        visited = new boolean[maps.length][maps[0].length()];
        cnt = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[i].length(); j++){
                int x = i;
                int y = j;
                if(!visited[x][y] && !arr[x][y].equals("X")){
                    bfs(x, y, maps, arr);
                    list.add(cnt);
                    cnt = 0;
                }
            }
        }
        if(list.size() == 0){
            return new int[]{-1};
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
    public void bfs(int x, int y, String[] maps, String[][] arr){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x,y});
        visited[x][y]= true;
        
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            x = current[0];
            y = current[1];

            cnt += Integer.parseInt(arr[x][y]);


            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
    
                if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length())  continue;
                    
                if(!visited[nx][ny] && !arr[nx][ny].equals("X")){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                }
            }
        }

    }
}