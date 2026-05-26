class Solution {
    static boolean[] visited;
    static int answer;
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        visited = new boolean[dungeons.length];
        dfs(k,0,dungeons);
        return answer;
    }
    public void dfs(int k, int cnt, int[][] dungeons){
        answer = Math.max(answer, cnt);
        
        for(int i = 0; i < dungeons.length; i++){
            if(visited[i]){
                continue;
            }
            
            visited[i] = true;
            if(k >= dungeons[i][0]){
                dfs(k - dungeons[i][1], cnt + 1, dungeons);
            }
            visited[i] = false;
        }
    }
}