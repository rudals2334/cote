import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for(int i = 0; i < str1.length()-1; i++){
            String ele = str1.substring(i,i+2);
            if(!Character.isLetter(ele.charAt(0)) || !Character.isLetter(ele.charAt(1))){
                continue;
            }
            map1.put(ele, map1.getOrDefault(ele, 0)+1);
        } 
        for(int i = 0; i < str2.length()-1; i++){
            String ele = str2.substring(i,i+2);
            if(!Character.isLetter(ele.charAt(0)) || !Character.isLetter(ele.charAt(1))){
                continue;
            }
            map2.put(ele, map2.getOrDefault(ele, 0)+1);
        } 
        
        if(map1.isEmpty() && map2.isEmpty()){
            return 65536;
        }

        int inter = 0;
        int union = 0;

        for(Map.Entry<String, Integer> entry : map1.entrySet()){
            if(map2.containsKey(entry.getKey())){
                inter += Math.min(entry.getValue(), map2.get(entry.getKey()));
                union += Math.max(entry.getValue(), map2.get(entry.getKey()));
            }else{
                union += entry.getValue();
            }
        }

        for(Map.Entry<String, Integer> entry : map2.entrySet()){
            if(!map1.containsKey(entry.getKey())){
                union += entry.getValue();
            }
        }

        double cal = (double)inter/union * 65536;
        int answer = (int)cal;
        return answer;
    }
}