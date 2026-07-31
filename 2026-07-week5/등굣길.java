class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n+1][m+1];
        int l = 1000000007;
        dp[1][1] = 1;
        for(int i = 0; i < puddles.length; i++){
            int a = puddles[i][0];
            int b = puddles[i][1];
            dp[b][a] = -1;
        }

        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                if(i==1 && j==1){
                    continue;
                }
                if(dp[i][j]==-1){
                    dp[i][j] = 0;
                    continue;
                }
                int up = dp[i-1][j];
                int left = dp[i][j-1];
                dp[i][j] = (up + left) % l;
            }   
        }
        int answer = dp[n][m];
        return answer;
    }
}