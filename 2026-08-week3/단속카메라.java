import java.util.Arrays;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes,(a,b) -> Integer.compare(a[1], b[1]));
        int answer = 0;
        int camera = Integer.MIN_VALUE;
        for(int[] route : routes){
            if(camera < route[0]){
                camera = route[1];
                answer++;
            }
        }
        return answer;
    }
}