import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < stages.length; i++){
            map.put(stages[i], map.getOrDefault(stages[i], 0) + 1);
        }
        double[][] arr = new double[N][2];
        int total = stages.length;
        for(int i = 1; i <= N; i++){
            int stay = map.getOrDefault(i, 0);
            double fail = 0;
            if(total!=0){
                fail = (double) stay / total;
            }
            total-=stay;
            arr[i-1][0] = i;
            arr[i-1][1] = fail;
        }
        Arrays.sort(arr,(a,b) -> {
            if(b[1]!=a[1]){
                return Double.compare(b[1], a[1]);
            }
            return (int)(a[0] - b[0]);
        });

        int[] answer = new int[N];
        for(int i = 0; i < N; i++){
            answer[i] = (int)arr[i][0];
        }
        return answer;
    }
}