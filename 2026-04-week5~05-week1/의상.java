import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        List<String> list = new ArrayList<>(map.keySet());

        int answer = 1;
        for(int i = 0; i < list.size(); i++){
            String a = list.get(i);
            answer *= (map.get(a)+1);
        }
        return answer - 1;
    }
}