import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> totalMap = new HashMap<>();

        for(int i = 0; i < records.length; i++){
            if(records[i].split(" ")[2].equals("IN")){
                map.put(records[i].split(" ")[1], records[i].split(" ")[0]);

            }else{
                int hour = Integer.parseInt(records[i].split(" ")[0].split(":")[0]) - Integer.parseInt(map.get(records[i].split(" ")[1]).split(":")[0]);
                int min = Integer.parseInt(records[i].split(" ")[0].split(":")[1]) - Integer.parseInt(map.get(records[i].split(" ")[1]).split(":")[1]);
                int total = (hour * 60) + min;
                
                totalMap.put(records[i].split(" ")[1], totalMap.getOrDefault(records[i].split(" ")[1], 0)+total);
                map.remove(records[i].split(" ")[1]);
            }
        }
        if(!map.isEmpty()){
            for(Map.Entry<String,String> entry : map.entrySet()){
                int hour = 23 - Integer.parseInt(entry.getValue().split(":")[0]);
                int min = 59 - Integer.parseInt(entry.getValue().split(":")[1]);
                int total = (hour * 60) + min;
                totalMap.put(entry.getKey(), totalMap.getOrDefault(entry.getKey(), 0) + total);

            }
        }
        List<String> list = new ArrayList<>(totalMap.keySet());
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            int total = totalMap.get(list.get(i));
            double park = Math.ceil((double)(total - fees[0]) / fees[2]);
            answer[i] = calculate(total, park, fees[0], fees[1], fees[3]);
        }
        
        return answer;
        
    }
    public static int calculate(int total,double park, int basic_min, int basic_fee, int per_fee){
        if(total > basic_min){
            return basic_fee + (int)park * per_fee;                 
        }else{
            return basic_fee;
        }
        
    }
}