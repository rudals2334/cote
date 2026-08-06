import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        for(int i = 0; i < gems.length; i++){
            set.add(gems[i]);
        }
        int cnt = set.size();
        Map<String,Integer> map = new HashMap<>();
        int left = 0;
        int minlen = Integer.MAX_VALUE;
        for(int right = 0; right < gems.length; right++){
            map.put(gems[right], map.getOrDefault(gems[right], 0)+1);
            
            while (map.size() == cnt) {
                int curlen = right - left + 1;
                if(curlen < minlen){
                    minlen = curlen;
                    answer[0] = left+1;
                    answer[1] = right+1;
                }
                map.put(gems[left], map.get(gems[left]) - 1);
                if(map.get(gems[left]) == 0){
                    map.remove(gems[left]);
                }
                left++;
            }
        }
        return answer;
    }
}