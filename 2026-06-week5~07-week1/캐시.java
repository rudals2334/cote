import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < cities.length; i++){
            cities[i] = cities[i].toLowerCase();
        }
        int answer = 0;
        int idx = 1;
        if(cacheSize==0){
            return cities.length * 5;
        }
        for(int i = 0; i < cities.length; i++){
            if(map.containsKey(cities[i])){
                map.put(cities[i], idx);
                answer++;
                idx++;
            }else{
                if(map.size()>=cacheSize){
                    String a = min(map);
                    map.remove(a);
                    map.put(cities[i], idx);
                    answer += 5;
                    idx++;
                }else{
                    map.put(cities[i], idx);
                    answer += 5;
                    idx++;
                }
            }
        }
        return answer;
    }
    public String min(Map<String, Integer> map){
        List<String> list = new ArrayList<>(map.keySet());
        list.sort((a,b) -> map.get(a) - map.get(b));
        return list.get(0);
    }
}