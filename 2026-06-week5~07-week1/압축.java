import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < 26; i++){
            String a = String.valueOf((char)('A' + i));
            map.put(a, i+1);
        }
        int dn = 27;
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        
        while (idx < msg.length()) {
            String word = "";
            while(idx + word.length() < msg.length()){
                String next = msg.substring(idx, idx + word.length() + 1);
                if(map.containsKey(next)){
                    word = next;
                }else{
                    break;
                }
            }
            list.add(map.get(word));
            if(idx + word.length() < msg.length()){
                String nw = msg.substring(idx, idx + word.length() + 1);
                map.put(nw, dn++);
            }
            idx += word.length();
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}