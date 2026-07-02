class Solution {
    static boolean[] visited;
    static int answer = 0;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, 0, dungeons);
        return answer;
    }
    public  void dfs(int k, int cnt, int[][] dungeons){
        answer = Math.max(answer, cnt);

        for(int i = 0; i < dungeons.length; i++){
            if(visited[i]) continue;

            if(k >= dungeons[i][0]){
                visited[i] = true;
                dfs(k-dungeons[i][1], cnt+1, dungeons);
                visited[i] = false;
            }
        }
    }
}