import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Safe_Area {
// 문제
// 재난방재청에서는 많은 비가 내리는 장마철에 대비해서 다음과 같은 일을 계획하고 있다. 먼저 어떤 지역의 높이 정보를 파악한다. 
// 이때, 문제를 간단하게 하기 위하여, 장마철에 내리는 비의 양에 따라 일정한 높이 이하의 모든 지점은 물에 잠긴다고 가정한다.
// 물에 잠기지 않는 안전한 영역이라 함은 물에 잠기지 않는 지점들이 위, 아래, 오른쪽 혹은 왼쪽으로 인접해 있으며 그 크기가 최대인 영역을 말한다. 
// 장마철에 내리는 비의 양에 따라서 물에 잠기지 않는 안전한 영역의 개수는 다르게 된다. 
// 어떤 지역의 높이 정보가 주어졌을 때, 장마철에 물에 잠기지 않는 안전한 영역의 최대 개수를 계산하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에는 어떤 지역을 나타내는 2차원 배열의 행과 열의 개수를 나타내는 수 N이 입력된다. N은 2 이상 100 이하의 정수이다. 둘째 줄부터 N개의 각 줄에는 2차원 배열의 첫 번째 행부터 N번째 행까지 순서대로 한 행씩 높이 정보가 입력된다. 각 줄에는 각 행의 첫 번째 열부터 N번째 열까지 N개의 높이 정보를 나타내는 자연수가 빈 칸을 사이에 두고 입력된다. 높이는 1이상 100 이하의 정수이다.

// 출력
// 첫째 줄에 장마철에 물에 잠기지 않는 안전한 영역의 최대 개수를 출력한다.  
    public static int n;
    public static boolean[][] visited;
    public static int[][] map;
    
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int max = 0;
        map = new int[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]>max){
                    max = map[i][j];
                }
            }
        }
        int cnt_max = 0;
        for(int i = 0; i <= max; i++){
            int cnt = 0;
            visited = new boolean[n][n];
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    
                    if(map[j][k] > i && !visited[j][k]){
                        cnt++;
                        dfs(j, k, i);
                    }
                }
            }
            if(cnt > cnt_max){
                cnt_max = cnt;
            }
        }
        System.out.println(cnt_max);

        

        
    }
    public static void dfs(int x, int y, int height){
        visited[x][y] = true;
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if(map[nx][ny] > height && !visited[nx][ny]){
                dfs(nx, ny, height);
            }

        }
    }
}
