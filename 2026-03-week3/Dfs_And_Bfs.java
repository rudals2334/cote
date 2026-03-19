import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Dfs_And_Bfs {
// 문제
// 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.  
// 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

// 입력
// 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 
// 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

// 출력
// 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다. 
    public static int n,m;
    public static boolean[] visited; 
    public static boolean[] visited2;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        
        visited = new boolean[n+1];
        visited2 = new boolean[n+1];
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
        for(int i = 0; i < n+1; i++){
            Collections.sort(graph.get(i)); 
        }
        dfs(x);
        System.out.println();
        bfs(x);
        
    }

    public static void dfs(int x){
        visited[x]=true;
        System.out.print(x + " ");
        for(int i  = 0; i < graph.get(x).size(); i++){
            int y = graph.get(x).get(i);
            if(!visited[y]){
                dfs(y);
            }
        }
    }

    public static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visited2[x] = true;
        while (!q.isEmpty()) {
            int k = q.poll();
            System.out.print(k + " ");
            for(int i = 0; i < graph.get(k).size(); i++){
                int y = graph.get(k).get(i);
                if(!visited2[y]){
                    q.offer(y);
                    visited2[y]=true;
                }

            } 
        }
    }
}
