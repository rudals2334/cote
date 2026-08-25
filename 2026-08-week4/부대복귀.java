import java.util.*;

class Solution {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] dist;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dist = new int[n + 1];
        Arrays.fill(dist, -1);

        bfs(destination);

        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]];
        }

        return answer;
    }

    public void bfs(int destination) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(destination);
        dist[destination] = 0;

        while(!queue.isEmpty()){
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