class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        for(long x = 1; x <= r2; x++){
            long bigY = (long)Math.floor(Math.sqrt((long) r2*r2 - x*x));
            long smallY;
            if(x < r1){
                smallY = (long)Math.ceil(Math.sqrt((long) r1*r1 - x*x));
            }else{
                smallY = 1;
            }
            answer += bigY - smallY + 1;
        }
        answer *= 4;
        answer += (long)(r2-r1+1) * 4;
        return answer;
    }
}