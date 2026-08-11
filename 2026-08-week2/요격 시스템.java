import java.util.Arrays;
class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets,(a,b) -> {
            if(a[1] == b[1]){
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        int answer = 1;
        int start = targets[0][1];
        for(int i = 1; i < targets.length; i++){
            if(targets[i][0] >= start){
                start = targets[i][1];
                answer++;
            }
        }
        return answer;
    }
}