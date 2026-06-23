import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Solution {
    public int solution(String[][] clothes) {
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            String item = clothes[i][0];
            String type = clothes[i][1];
            map.put(type, map.getOrDefault(type, 0)+1); 
        }
        List<String> list = new ArrayList<>(map.keySet());

        int answer = 1;
        for(int i = 0; i < list.size(); i++){
            String a = list.get(i);
            int b = map.get(a) + 1;
            answer = answer * b;
        }
        return answer-1;
    }
}