import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for(int i = 0; i < arr1.length - 1; i++){
            if((arr1[i] >= 'A' && arr1[i] <= 'Z') && (arr1[i+1] >= 'A' && arr1[i+1] <= 'Z')){
                String element = "" + arr1[i] + arr1[i+1]; 
                map1.put(element, map1.getOrDefault(element, 0) + 1);
            }else{
                continue;
            }
        }
        for(int i = 0; i < arr2.length - 1; i++){
            if((arr2[i] >= 'A' && arr2[i] <= 'Z') && (arr2[i+1] >= 'A' && arr2[i+1] <= 'Z')){
                String element = "" + arr2[i] + arr2[i+1];
                map2.put(element, map2.getOrDefault(element, 0) + 1);
            }else{
                continue;
            }
        }

        if(map1.isEmpty() && map2.isEmpty()){
            return 65536;
        }

        int intersection = 0;
        int union = 0;

        for(Map.Entry<String, Integer> entry : map1.entrySet()){
            if(map2.containsKey(entry.getKey())){
                int a = Math.min(map2.get(entry.getKey()), entry.getValue());
                intersection += a;
            }
        }

        for(Map.Entry<String, Integer> entry : map1.entrySet()){
            if(map2.containsKey(entry.getKey())){
                int a = Math.max(map2.get(entry.getKey()), entry.getValue());
                union += a;
            }else{
                int a = entry.getValue();
                union += a;
            }
        }
        for(Map.Entry<String,Integer> entry : map2.entrySet()){
            if(!map1.containsKey(entry.getKey())){
                int a = entry.getValue();
                union += a;
            }
        }

        double cal = (double)intersection/union * 65536;
        int answer = (int)cal;
        return answer;
    }
}