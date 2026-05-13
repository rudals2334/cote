import java.util.HashMap;
import java.util.Map;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        Map<String,Integer> map = new HashMap<>();
        
        for(int i = 0; i < cities.length; i++){
            cities[i] = cities[i].toLowerCase();
        }
        
        if(cacheSize==0){
            return cities.length * 5;
        }
        int answer = 0;
        int min = Integer.MAX_VALUE;
        String minkey = "";
        for(int i = 0; i < cities.length; i++){
            if(map.containsKey(cities[i])){
                map.remove(cities[i]);
                map.put(cities[i], i);
                answer++;
            }else{
                if(map.size() < cacheSize){
                    map.put(cities[i], i);
                    answer += 5;
                }else{
                    for(Map.Entry<String,Integer> entry : map.entrySet()){
                        if(entry.getValue() < min){
                            min = entry.getValue();
                            minkey = entry.getKey();
                        }
                    }
                    map.remove(minkey);
                    map.put(cities[i], i);
                    answer += 5;
                    min = Integer.MAX_VALUE;
                }
            }
        }
        return answer;
    }
}