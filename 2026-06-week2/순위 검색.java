import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    static Map<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        for(String s : info){
            String[] arr = s.split(" ");
            String[] person = {arr[0],arr[1],arr[2],arr[3]};
            int score = Integer.parseInt(arr[4]);
            makeKey(0, "", person, score);
        }

        for(List<Integer> scores : map.values()){
            Collections.sort(scores);
        }
        for(int i = 0; i < query.length; i++){
            String q = query[i].replace(" and ", " ");
            String[] arr = q.split(" ");
            String key = arr[0] + arr[1] + arr[2] + arr[3];
            int targetScore = Integer.parseInt(arr[4]);

            if(!map.containsKey(key)){
                answer[i] = 0;
                continue;
            }

            List<Integer> scores = map.get(key);

            int idx = lowerBound(scores, targetScore);
            answer[i] = scores.size() - idx;

        }
        return answer;
        
    }

    public void makeKey(int depth, String key, String[] person, int score){
        if(depth == 4){
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(score);
            return;
        }
        makeKey(depth+1, key+person[depth], person, score);
        makeKey(depth+1, key + "-", person, score);
    }

    public int lowerBound(List<Integer> scores, int target){
        int left = 0;
        int right = scores.size();

        while(left < right){
            int mid = (left + right) / 2;
            if(scores.get(mid) >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}