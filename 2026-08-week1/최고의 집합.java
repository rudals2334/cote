import java.util.Arrays;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer= new int[n];
        if(n > s){
            return new int[]{-1};
        }
        int a = s / n;
        int b = s % n;
        for(int i = 0; i < answer.length; i++){
            answer[i] = a;
        }
        int i = 0;
        while(b > 0){
            if(i < answer.length){
                answer[i++]++;
            }else{
                i = 0;
                answer[i++]++;
            }
            b--;
        }
        Arrays.sort(answer);
        return answer;
    }
}