import java.util.HashMap;
import java.util.Map;
class Solution {
    public int[] solution(int n, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int[] answer = new int[2];
        map.put(words[0], 1);
        char a = words[0].charAt(words[0].length()-1);
        for(int i = 1; i < words.length; i++){
            map.put(words[i], map.getOrDefault(words[i], 0)+1);
            if(words[i].charAt(0) != a || map.get(words[i]) >= 2){
                if((i+1) % n == 0){
                    answer[0] = n;
                }else{
                    answer[0] = (i+1) % n;
                }
                answer[1] = i / n + 1;
                break;
            }
            
            a = words[i].charAt(words[i].length()-1);
        }
        return answer;
    }
}