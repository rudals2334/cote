
import java.util.Arrays;
import java.util.HashMap;
class Solution {
    public long solution(int[] weights) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long answer = 0;
        Arrays.sort(weights);
        for(int i = 0; i < weights.length; i++){
            int now = weights[i];
            
            if(map.containsKey(now)){
                answer += map.get(now);
            }

            if(now * 2 % 3 == 0){
                int target = now * 2 / 3;
                if(map.containsKey(target)){
                    answer += map.get(target);
                }
            }
            if(now * 1 % 2 == 0){
                int target = now * 1 / 2;
                if(map.containsKey(target)){
                    answer += map.get(target);
                }
            }
            if(now * 3 % 4 == 0){
                int target = now * 3 / 4;
                if(map.containsKey(target)){
                    answer += map.get(target);
                }
            }

            
            map.put(weights[i], map.getOrDefault(weights[i],0)+1);
        }
        return answer;
    }
}