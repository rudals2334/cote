import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {

        HashMap<String,Integer> map = new HashMap<>();
        for(String s : participant){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for(String s : completion){
            map.put(s, map.get(s) - 1);
            if(map.get(s) == 0){
                map.remove(s);
            }
        }
        
        for(String key : map.keySet()){
            return key;
        }
        return "";
    }
}
