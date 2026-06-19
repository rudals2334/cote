import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    static List<int[]>[] graph;
    static int[] dist;
    public int solution(int N, int[][] road, int K) {
        graph = new ArrayList[N+1];
        dist = new int[N+1];

        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] r : road){
            int a = r[0];
            int b = r[1];
            int cost = r[2];

            graph[a].add(new int[]{b,cost});
            graph[b].add(new int[]{a,cost});
        }
        daikstra(1);
        int answer = 0;
        for(int i = 0; i <= N; i++){
            if(dist[i] <= K){
                answer++;
            }
        }
        return answer;
    }
    public void daikstra(int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;
        pq.offer(new int[]{start,0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];
            if(dist[now] < cost) continue;

            for(int[] next : graph[now]){
                int nextNode = next[0];
                int weight = next[1];
                int nextCost = cost + weight;

                if(dist[nextNode] > nextCost){
                    dist[nextNode] = nextCost;
                    pq.offer(new int[]{nextNode,nextCost});
                }
            }
        }
    }
}