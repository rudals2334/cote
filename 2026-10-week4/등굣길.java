class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m+1][n+1];
        int l = 1000000007;
        dp[1][1] = 1;

        for(int i = 0; i < puddles.length; i++){
            int a = puddles[i][0];
            int b = puddles[i][1];
            dp[a][b] = -1;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(i==1 && j==1){
                    continue;
                }

                if(dp[i][j] == -1){
                    dp[i][j] = 0;
                    continue;
                }

                int up = dp[i][j-1];
                int left = dp[i-1][j];
                dp[i][j] = (up+left) % l;
            }
        }

        return dp[m][n];
    }
}