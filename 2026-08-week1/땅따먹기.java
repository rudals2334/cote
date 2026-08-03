class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][4];
        for(int i = 0; i < 4; i++){
            dp[0][i] = land[0][i];
        }

        for(int i = 1; i < land.length; i++){
            for(int j = 0; j < 4; j++){
                if(j==0){
                    dp[i][j] = land[i][j] + Math.max(dp[i-1][1], Math.max(dp[i-1][2], dp[i-1][3]));
                }
                if(j==1){
                    dp[i][j] = land[i][j] + Math.max(dp[i-1][0], Math.max(dp[i-1][2], dp[i-1][3]));
                }
                if(j==2){
                    dp[i][j] = land[i][j] + Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][3]));
                }
                if(j==3){
                    dp[i][j] = land[i][j] + Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[i].length; j++){
                answer = Math.max(answer, dp[i][j]);
            }
        }
        return answer;
    }
}