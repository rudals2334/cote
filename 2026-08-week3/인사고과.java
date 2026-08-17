import java.util.Arrays;
class Solution {
    public int solution(int[][] scores) {
        int wa = scores[0][0];
        int wb = scores[0][1];
        Arrays.sort(scores,(a,b) -> {
            if(a[0]==b[0]){
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        int max = 0;
        int rank = 1;
        for(int[] score : scores){
            if(score[1] < max){
                if(score[0] == wa && score[1] == wb){
                    return -1;
                }
                continue;
            }else{
                max = score[1];
                if(score[0] + score[1] > wa + wb){
                    rank++;
                }
            }
        }
        return rank;
    }
}