import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        int dn = 27;
        for(int i = 0; i < 26; i++){
            String s = String.valueOf((char)('A' + i));
            map.put(s, i+1);
        }
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while(i < msg.length()){
            String word = "";
            while(i + word.length() < msg.length()){
                String next = msg.substring(i, i + word.length() + 1);
                if(map.containsKey(next)){
                    word = next;
                }else{
                    break;
                }
            }
            list.add(map.get(word));

            if(i + word.length() < msg.length()){
                String newWord = msg.substring(i, i + word.length() + 1);
                map.put(newWord, dn++);
            }
            i += word.length();
        }
        int[] answer = new int[list.size()];
        for(int j = 0; j < list.size(); j++){
            answer[j] = list.get(j);
        }
        return answer;
    }
}