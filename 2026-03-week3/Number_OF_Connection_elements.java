import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Number_OF_Connection_elements {
// 문제
// 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 
// 같은 간선은 한 번만 주어진다.

// 출력
// 첫째 줄에 연결 요소의 개수를 출력한다.
    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cnt = 0;
        visited = new boolean[n+1];
        for(int i = 0; i < n+1; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < m; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for(int i = 1; i <= n; i++){
            if(!visited[i]){
                cnt++;
                dfs(i);
            }
        }
        System.out.println(cnt);
        
    }
    public static void dfs(int x){
        visited[x] = true;
        for(int i = 0; i < graph.get(x).size(); i++){
            int y = graph.get(x).get(i);
            if(!visited[y]){
                dfs(y);
            }
        }
    }
}
