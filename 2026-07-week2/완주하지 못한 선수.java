import java.util.HashMap;
import java.util.Map;
class Solution {
    public String solution(String[] participant, String[] completion) {

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < participant.length; i++){
            map.put(participant[i], map.getOrDefault(participant[i], 0)+1);
        }

        for(int i = 0; i < completion.length; i++){
            int a = map.get(completion[i]) - 1;
            if(a==0){
                map.remove(completion[i]);
            }else{
                map.put(completion[i], a);
            }
        }

        for(String key : map.keySet()){
            return key;
        }
        return "";
    }
}