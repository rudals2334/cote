import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Finding_Parent_Of_Tree {
// 문제
// 루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.

// 출력
// 첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean visited[];
    public static int parent[];
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        parent = new int[n+1]; //부모 노드를 저장할 배열
        for(int i = 0; i < n+1; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        // dfs OR bfs 둘 중 하나로 쓰면 됨
        dfs(1);
        bfs(1);
        for(int i = 2; i < parent.length; i++){
            System.out.println(parent[i]);
        }
        
    }
    public static void dfs(int x){
        visited[x] = true;
        for(int i = 0; i < graph.get(x).size(); i++){
            int y = graph.get(x).get(i);
            if(!visited[y]){
                parent[y]=x; 
                dfs(y);
            }
        }
    }

    public static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visited[x] = true;
        while(!q.isEmpty()){
            int k = q.poll();
            for(int i = 0; i < graph.get(k).size(); i++){
                int y = graph.get(k).get(i);
                if(!visited[y]){
                    q.offer(y);
                    parent[y]=k;               
                    visited[y] = true;
                }
            }
        }
    }
}
