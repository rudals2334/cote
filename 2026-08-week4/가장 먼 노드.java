import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static Integer[] dist;
    public int solution(int n, int[][] vertex){
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        dist = new Integer[n+1];
        Arrays.fill(dist, -1);
        
        for(int i = 0; i < vertex.length; i++){
            int a = vertex[i][0];
            int b = vertex[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs(1);
        int max = -1;
        for(int i = 0; i < dist.length; i++){
            if(dist[i] > max){
                max = dist[i];
            }
        }
        int answer = 0;
        for(int k : dist){
            if(k==max){
                answer++;
            }
        }
        return answer;

    }
    public void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        dist[start] = 0;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for(int next : graph.get(current)){
                if(dist[next] != -1){
                    continue;
                }
                dist[next] = dist[current] + 1;
                queue.add(next);
            }
        }
    }
}