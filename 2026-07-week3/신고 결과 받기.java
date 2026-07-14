import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> indexMap = new HashMap<>();
        for(int i = 0; i < id_list.length; i++){
            indexMap.put(id_list[i], i);
        }

        Set<String> reportSet = new HashSet<>();
        for(String s : report){
            reportSet.add(s);
        }

        Map<String,Integer> reportCnt = new HashMap<>();
        for(String s : reportSet){
            String[] arr = s.split(" ");
            reportCnt.put(arr[1], reportCnt.getOrDefault(arr[1], 0)+1);
        }

        int[] answer = new int[id_list.length];
        for(String s : reportSet){
            String[] arr = s.split(" ");
            if(reportCnt.get(arr[1]) >= k){
                int a = indexMap.get(arr[0]);
                answer[a]++;
            }
        }
        return answer;
    }
}