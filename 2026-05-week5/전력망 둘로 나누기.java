import java.util.*;

class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i = 0; i < wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];

            graph.get(a).remove(Integer.valueOf(b));
            graph.get(b).remove(Integer.valueOf(a));

            visited = new boolean[n+1];

            int cnt = dfs(graph, 1, 0);
            answer = Math.min(answer, Math.abs(cnt-(n-cnt)));
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        return answer;
    }
    public static int dfs(ArrayList<ArrayList<Integer>> graph, int x, int cnt){
        visited[x] = true;
        cnt++;
        for(int i = 0; i < graph.get(x).size(); i++){
            int y = graph.get(x).get(i);
            if(!visited[y]){
                cnt = dfs(graph, y, cnt);
            }
        }
        return cnt;
    }
}