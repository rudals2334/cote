import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Numbering_complex {
// 문제
// <그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 
// 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 
// 대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 
// 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.

// 입력
// 첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.

// 출력
// 첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.    
    public static boolean[][] visited;
    public static int[][] map;
    public static int n;
    public static int cnt;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         n = Integer.parseInt(br.readLine());
         visited = new boolean[n][n];
         map = new int[n][n];
         List<Integer> list = new ArrayList<>();
         

         for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            for(int j = 0; j < n; j++){
                map[i][j] = num.charAt(j) - '0';
            }
         }

         for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                cnt = 0;
                if(map[i][j] == 1 && !visited[i][j]){
                    list.add(dfs(i, j));
                }
            }
         }
         
         Collections.sort(list);
         System.out.println(list.size());
         for(int k : list){
            System.out.println(k);
         }


    }
    public static int dfs(int x, int y){
        visited[x][y] = true;
        cnt++;
        int dx[] = {1,-1,0,0};
        int dy[] = {0,0,1,-1};

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

            if(map[nx][ny] == 1 && !visited[nx][ny]){
                dfs(nx, ny);
            }
        }
        return cnt;
    }
}
