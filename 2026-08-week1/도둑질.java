class Solution {
    public int solution(int[] money) {
        int n = money.length;
        int[] m1 = new int[n-1];
        int[] m2 = new int[n-1];
        for(int i = 0; i < m1.length; i++){
            m1[i] = money[i];
        }
        for(int i = 1; i <= m2.length; i++){
            m2[i-1] = money[i];
        }
        int[] dp1 = new int[money.length];
        int[] dp2 = new int[money.length];

        dp1[0] = m1[0];
        dp1[1] = Math.max(m1[0], m1[1]);
        dp2[0] = m2[0];
        dp2[1] = Math.max(m2[0], m2[1]);

        for(int i = 2; i < m1.length; i++){
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + m1[i]);
        }  

        for(int i = 2; i < m2.length; i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + m2[i]);
        }  

        int a1 = 0;
        int a2 = 0;
        for(int i = 0; i < dp1.length; i++){
            if(dp1[i] > a1){
                a1 = dp1[i];
            }
            if(dp2[i] > a2){
                a2 = dp2[i];
            }
        }
        return Math.max(a1, a2);
    }
}