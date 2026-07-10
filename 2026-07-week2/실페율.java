import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < stages.length; i++){
            int lv = stages[i];
            map.put(lv, map.getOrDefault(lv, 0)+1);
        }
        double[][] arr = new double[N][2];
        int k = stages.length;
        for(int i = 0; i < N; i++){
            arr[i][0] = i+1;
            if(k==0){
                arr[i][1] = 0;
            }else{
                arr[i][1] = (double)map.getOrDefault(i+1,0) / k;
            }
            k -= map.getOrDefault(i+1,0);
        }
        Arrays.sort(arr,(a,b) -> {
            if(a[1]!=b[1]){
                return Double.compare(b[1], a[1]);
            }
            return (int)(a[0]-b[0]);
        });

        for(int i = 0; i < answer.length; i++){
            answer[i] = (int)arr[i][0];
        }
        return answer;
    }
}