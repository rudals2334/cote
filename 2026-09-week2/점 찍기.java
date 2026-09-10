class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for(int x = 0; x <= d; x+=k){
            long a = (int)Math.floor(Math.sqrt((long)d*d - (long)x*x));
            answer += a / k + 1;
        }
        return answer;
    }
}