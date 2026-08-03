class Solution {
    public int solution(int sticker[]) {
        int n = sticker.length;
        if(n==1){
            return sticker[0];
        }
        if(n==2){
            return Math.max(sticker[0], sticker[1]);
        }
        int[] s1 = new int[n-1];
        int[] s2 = new int[n-1];
        for(int i = 0; i < n-1; i++){
            s1[i] = sticker[i];
        }
        for(int i = 1; i < n; i++){
            s2[i-1] = sticker[i];
        }

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        dp1[0] = s1[0];
        dp1[1] = Math.max(s1[0], s1[1]);
        
        dp2[0] = s2[0];
        dp2[1] = Math.max(s2[0], s2[1]);

        for(int i = 2; i < s1.length; i++){
            dp1[i] = Math.max(dp1[i-2] + s1[i], dp1[i-1]);
            dp2[i] = Math.max(dp2[i-2] + s2[i], dp2[i-1]);
        }
        
        return Math.max(dp1[n-2], dp2[n-2]);
    }
}