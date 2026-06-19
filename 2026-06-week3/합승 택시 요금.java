import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
class Solution {
    static List<int[]>[] graph;
    static int[] distS;
    static int[] distA;
    static int[] distB;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList[n+1];
        distS = new int[n+1];
        distA = new int[n+1];
        distB = new int[n+1];

        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] f : fares){
            int x = f[0];
            int y = f[1];
            int cost = f[2];

            graph[x].add(new int[]{y,cost});
            graph[y].add(new int[]{x,cost});
        }
        daikstra(distS, s);
        daikstra(distA, a);
        daikstra(distB, b);
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i <= n; i++){
            answer = Math.min(answer, distS[i] + distA[i] + distB[i]);
        }

        return answer;
    }
    
    public void daikstra(int[] dist, int start){
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