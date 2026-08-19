import java.util.Arrays;

class Solution {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs,(a,b) -> a[2] - b[2]);
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        int answer = 0;
        int cnt = 0;
        for(int[] cost : costs){
            int a = cost[0];
            int b = cost[1];
            if(find(a) != find(b)){
                unoin(a, b);
                answer += cost[2];
                cnt++;
                if(cnt == n-1){
                    break;
                }
            }
        }
        return answer;
    }
    public int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public void unoin(int a, int b){
        int rootA = parent[a];
        int rootB = parent[b];

        parent[rootB] = rootA;
    }
}