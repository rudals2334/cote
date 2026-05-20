import java.util.ArrayList;
class Solution {
    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n+1];
        int answer = 0;
        
        for(int i = 0; i < n+1; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < computers.length; i++){
            for(int j = 0; j < computers[i].length; j++){
                if(i != j && computers[i][j] == 1){
                    graph.get(i+1).add(j+1);
                }
            }
        }
        
        for(int i = 1; i <= n; i++){
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
    void dfs(int x){
        visited[x] = true;
        for(int i = 0; i < graph.get(x).size(); i++){
            int y = graph.get(x).get(i);
            if(!visited[y]){
                dfs(y);
            }
        }
    }
}