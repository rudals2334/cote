import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static boolean visited[];
    public static boolean visited2[];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args)throws Exception  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        visited2 = new boolean[n+1];
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < m; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        
        for(int i = 0; i <= n; i++){
            Collections.sort(graph.get(i));
        }
        dfs(z);
        System.out.println();
        bfs(z);

    }
    public static void dfs(int x){
        visited[x] = true;
        System.out.print(x + " ");
        for(int i = 0; i < graph.get(x).size(); i++){
            int y = graph.get(x).get(i);
            if(!visited[y]){
                visited[y] = true;
                dfs(y);
            }
        }
    }

    public static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        while (!q.isEmpty()) {
            int k = q.poll();
            visited2[k] = true;
            System.out.print(k + " ");
            for(int i = 0 ; i < graph.get(k).size(); i++){
                int y = graph.get(k).get(i);
                if(!visited2[y]){
                    q.offer(y);
                    visited2[y] = true;
                }
            }
        }
    }
}
