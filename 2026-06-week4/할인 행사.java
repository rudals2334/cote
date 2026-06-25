import java.util.HashMap;
import java.util.Map;
class Solution {
    static int answer;
    public int solution(String[] want, int[] number, String[] discount) {
        answer = 0;
        for(int i = 0; i <= discount.length-10; i++){
            Map<String, Integer> map = new HashMap<>();

            for(int j = i; j < i+10; j++){
                map.put(discount[j], map.getOrDefault(discount[j], 0)+1);
            }
            mart(map, want, number);
        }
        return answer;
    }
    public void mart(Map<String, Integer> map, String[] want, int[] number){
        for(int i = 0; i < want.length; i++){
            if(map.getOrDefault(want[i], 0) != number[i]){
                return;
            }
        }
        answer++;
    }
}