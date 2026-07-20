import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int solution(int N, int[][] road, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        List<List<int[]>> graph = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < road.length; i++){
            int a = road[i][0];
            int b = road[i][1];
            int cost = road[i][2];
            graph.get(a).add(new int[] {b,cost});
            graph.get(b).add(new int[] {a,cost});
        }
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        pq.offer(new int[] {1,0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int current = now[0];
            int currentCost = now[1];

            if(currentCost > dist[current]) continue;

            for(int[] next : graph.get(current)){
                int nextNode = next[0];
                int weight = next[1];
                int nextCost = currentCost + weight;
                if(nextCost < dist[nextNode]){
                    dist[nextNode] = nextCost;
                    pq.offer(new int[] {nextNode, nextCost});
                }
            }
        }
        int answer = 0;
        for(int i = 1; i <= N; i++){
            if(dist[i] <= K){
                answer++;
            }
        }
        return answer;
    }
}