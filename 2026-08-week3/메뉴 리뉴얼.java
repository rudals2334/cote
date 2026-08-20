import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
    static HashMap<String, Integer> map = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for(String order : orders){
            char[] arr = order.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);

            for(int len : course){
                dfs(sorted, 0, "", len);
            }
        }

        for(int len : course){
            int max = 0;
            for(String key : map.keySet()){
                if(key.length() == len){
                    max = Math.max(max, map.get(key));
                }
            }

            for(String key : map.keySet()){
                if(key.length() == len && map.get(key) == max && max >= 2){
                    answer.add(key);
                }
            }
        }

        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    public void dfs(String order, int start, String current, int targetLen){
        if(current.length() == targetLen){
            map.put(current, map.getOrDefault(current,0)+1);
            return;
        }
        for(int i = start; i < order.length(); i++){
            dfs(order, i+1, current + order.charAt(i), targetLen);
        }
    }
}