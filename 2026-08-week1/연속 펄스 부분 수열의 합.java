class Solution {
    public long solution(int[] sequence) {
        long[] seq1 = new long[sequence.length];
        long[] seq2 = new long[sequence.length];
        int[] purse = {1,-1};
        int[] purse2 = {-1,1};
        for(int i = 0; i < seq1.length; i++){
            seq1[i] = sequence[i] * purse[i%(purse.length)];
            seq2[i] = sequence[i] * purse2[i%(purse2.length)];
        }

        long[] dp1 = new long[sequence.length];
        long[] dp2 = new long[sequence.length];
        dp1[0] = seq1[0];
        dp2[0] = seq2[0];

        long answer = Math.max(dp1[0], dp2[0]);
        for(int i = 1; i < sequence.length; i++){
            dp1[i] = Math.max(dp1[i-1] + seq1[i] , seq1[i]);
            dp2[i] = Math.max(dp2[i-1] + seq2[i] , seq2[i]);

            answer = Math.max(answer, Math.max(dp1[i], dp2[i]));            
        }
        return answer;
    }
}