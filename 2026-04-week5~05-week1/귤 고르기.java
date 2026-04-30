import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        
        for(int i : map.keySet()){
            list.add(map.get(i));
        }

        list.sort((a,b) -> {
            return b-a;
        });

        int i = 0;
        while(k>0){
            k -= list.get(i);
            i++;
        }
        return i;
    }
}