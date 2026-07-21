import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    static List<List<int[]>> graph = new ArrayList<>();
    static int[] distS;
    static int[] distA;
    static int[] distB;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        distS = new int[n+1];
        distA = new int[n+1];
        distB = new int[n+1];

        for(int i = 0; i < fares.length; i++){
            int from = fares[i][0];
            int to = fares[i][1];
            int cost = fares[i][2];
            graph.get(from).add(new int[] {to,cost});
            graph.get(to).add(new int[] {from,cost});
        }
        daikstra(distS, s);
        daikstra(distA, a);
        daikstra(distB, b);

        int answer = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            answer = Integer.min(answer, distS[i] + distA[i] + distB[i]);
        }
        return answer;
    }
    public void daikstra(int[] dist, int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.offer(new int[] {start,0});

        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int cur = now[0];
            int cost = now[1];
            if(dist[cur] < cost) continue;

            for(int[] next : graph.get(cur)){
                int nextNode = next[0];
                int weight = next[1];
                int nextCost = cost + weight;
                if(nextCost < dist[nextNode]){
                    dist[nextNode] = nextCost;
                    pq.offer(new int[] {nextNode, nextCost});
                }
            }
        }
        return;
    }
}