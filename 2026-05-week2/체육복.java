import java.util.Arrays;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int cnt = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i] == reserve[j]){
                    cnt++;
                    lost[i] = 200;
                    reserve[j] = 100;
                }
            }
        }

        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i]-1 == reserve[j] || lost[i] + 1 == reserve[j]){
                    cnt++;
                    reserve[j] = 100;
                    break;
                }
            }
        }
        return cnt;
    }
}